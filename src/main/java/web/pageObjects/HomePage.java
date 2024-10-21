package web.pageObjects;

import web.controllers.BasePageController;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class HomePage extends BasePageController {

    //    @FindBy(css = "input[value='Log In']")
//    @CacheLookup
//    private static WebElement btnLogin;
    By txtUsernameLoginMenu = By.cssSelector("#loginPanel [name= 'username']");
    By txtPasswordLoginMenu = By.cssSelector("#loginPanel [name= 'password']");
    By btnLogin = By.cssSelector("input[value='Log In']");
    By btnLogout = By.cssSelector("a[href='logout.htm']");
    By msgTitle = By.cssSelector(".title");
    By lknForgotLoginInfo = By.cssSelector("#loginPanel a[href*='lookup']");
    By lknRegister = By.cssSelector("#loginPanel a[href*='register']");
    // ======= leftMenu =======
    By lknAboutUsLeftMenu = By.cssSelector(".leftmenu a[href*='about']");
    By lknServicesLeftMenu = By.cssSelector(".leftmenu a[href*='services']");
    By lknProductsLeftMenu = By.cssSelector(".leftmenu a[href*='products']");
    By lknLocationsLeftMenu = By.cssSelector(".leftmenu a[href*='contacts']");
    By lknLinksContainerMenu = By.cssSelector(".leftmenu li");


    public HomePage(WebDriver driver){
        super(driver);
    }

    public void setUsername(String username){
        _clear(txtUsernameLoginMenu, 5);
        _sendKeys(txtUsernameLoginMenu, username, 5);
    }

    public void setPassword(String password){
        _clear(txtPasswordLoginMenu, 5);
        _sendKeys(txtPasswordLoginMenu, password, 5);
    }

    public boolean isMyAccountExist(){
        System.out.println("Letter on page: " + _getText(msgTitle,5));
        if(Objects.equals(_getText(msgTitle, 5), "Error!")){
            return false;
        }else {
            return true;
        }
    }

    public void clickOnLoginButton(){
        _click(btnLogin, 5);
    }

    public void clickOnLogout(){
        _click(btnLogout, 5);
    }

    public void clickOnRegisterLkn(){
        _click(lknRegister, 5);
    }

    public void createsListOfLinks() throws IOException, ParseException, InterruptedException {
        List<WebElement> linkList = driver.findElements(By.cssSelector(".leftmenu li"));
        List<String> nameList = new ArrayList<>();
        for (WebElement locator : linkList){
            nameList.add(locator.getText());
        }
        clickAndValidateLink(nameList);
    }

    public void clickAndValidateLink(List<String> nameList) throws IOException, ParseException, InterruptedException {
        /**
         * Receives the list of links texts and skip the latest one as wasn't required for this practice
         * For Products or Locations are opened in new tab openLinkInNewTab()
         * For other are opened in same tab openLinkInSameTab()
         * Validates if the current link in the tab is expected, if yes pass if not fails
         * .\testData\expected_urls.json
         */
        for(String element : nameList.subList(1, 5)){
            String currentUrl = "";
            String expectedUrl = _readJsonFile(".\\testData\\expected_urls.json", element);
            By locator = By.xpath(String.format("//a[contains(text(), '%s')]", element));
            if(element.equals("Products") || element.equals("Locations")){
                currentUrl = openLinkInNewTab(locator, element);
            }else{
                currentUrl = openLinkInSameTab(locator, element);
            }

            if(Objects.equals(currentUrl, expectedUrl)){
                System.out.println("PASS - current: " + currentUrl + " ** expected: " + expectedUrl);
            }else{
                System.out.println("FAILED - current: " + currentUrl + " ** expected: " + expectedUrl);
            }
        }
    }

    public String openLinkInNewTab(By locator, String element) throws InterruptedException {
        System.out.println("clicking on: " + element);
        _sendKeys(locator, Keys.chord(Keys.CONTROL , Keys.SHIFT , Keys.RETURN),5);
        _switchToWindow(1);
        Thread.sleep(2000);
        String[] currentUrl = _getCurrentUrl().split(";");
        _close();
        _switchToWindow(0);

        return currentUrl[0];
    }

    public String openLinkInSameTab(By locator, String element){
        System.out.println("clicking on: " + element);
        _click(locator, 5);
        String[] currentUrl = _getCurrentUrl().split(";");

        return currentUrl[0];
    }
}
