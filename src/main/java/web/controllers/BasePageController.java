package web.controllers;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class BasePageController {

    public WebDriver driver;

    public BasePageController(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void _get(String url){
        this.driver.get(url);
    }

    protected String _getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    protected WebElement _findElement(By locator){
        return this.driver.findElement(locator);
    }

    protected List<WebElement> _findElements(By locator){
        return this.driver.findElements(locator);
    }

    public void explicitFluentWaitTest(int secsTimeout,int pollingTime, By element){
        WebElement revealedElement = _findElement(element);
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(secsTimeout))
                        .pollingEvery(Duration.ofMillis(pollingTime))
                        .ignoring(ElementNotInteractableException.class);

        wait.until(d -> {revealedElement.isDisplayed();return true;});
    }
    protected void _waitUntilElementIsVisible(By locator, int secsTimeout){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(secsTimeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void _waitUntilElementIsClickable(By locator, int secsTimeout){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(secsTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void _waitUntilElementIsInvisible(By locator, int secsTimeout){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(secsTimeout));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void _waitUntilAlertIsPresent(int secsTimeout){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(secsTimeout));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    protected Boolean _isDisplayed(By locator, int secsTimeout){
        _waitUntilElementIsInvisible(locator, secsTimeout);
        try{
            return _findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    protected void _click(By locator, int secsTimeout){
        _waitUntilElementIsClickable(locator, secsTimeout);
        _findElement(locator).click();
    }

    protected void _clear(By locator, int secsTimeout){
        _waitUntilElementIsVisible(locator, secsTimeout);
        _findElement(locator).clear();
    }

    protected void _sendKeys(By locator, String text, int secsTimeout){
        _waitUntilElementIsVisible(locator, secsTimeout);
        _findElement(locator).sendKeys(text);
    }

    protected void _selectByVisibleText(By locator, String text, int secsTimeout){
        _waitUntilElementIsVisible(locator, secsTimeout);
        Select option = new Select(this.driver.findElement(locator));
        option.selectByVisibleText(text);
    }

    protected String _getText(By locator, int secsTimeout){
        _waitUntilElementIsVisible(locator, secsTimeout);
        return _findElement(locator).getText();
    }

    protected String _getAttribute(By locator, String attributeType, int secsTimeout){
        _waitUntilElementIsVisible(locator, secsTimeout);
        return _findElement(locator).getAttribute(attributeType);
    }

    protected String _getAlertText(int secsTimeout){
        _waitUntilAlertIsPresent(secsTimeout);
        return this.driver.switchTo().alert().getText();
    }

    protected void _acceptAlert(int secsTimeout){
        _waitUntilAlertIsPresent(secsTimeout);
        this.driver.switchTo().alert().accept();
    }

    protected void _dismissAlert(int secsTimeout){
        _waitUntilAlertIsPresent(secsTimeout);
        this.driver.switchTo().alert().dismiss();
    }

    protected void _switchToWindow(int option){
        String[] windowOpen = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(windowOpen[option]);
    }

    protected void _close(){
        this.driver.close();
    }

    protected void _quit(){
        this.driver.quit();
    }

    protected String _readJsonFile(String jsonPath, String attribute) throws IOException, ParseException {
        FilesController fc = new FilesController(jsonPath);
        return fc.readJsonFile(jsonPath, attribute);
    }
}