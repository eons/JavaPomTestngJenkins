package pageObjects;

import controllers.BasePageController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PFDDinnerRegistrationPage extends BasePageController {

    public PFDDinnerRegistrationPage(WebDriver driver){
        super(driver);
    }

    By lknPopupForm = (By.cssSelector(".awe-itc a[href='/PopupFormDemo.aspx']"));
    By btnCookies = (By.cssSelector("button[id='btnCookie']"));
    By btnCreate = (By.xpath("//button[contains(text(), 'Create')]"));
    By txtName = (By.cssSelector(".awe-elcont #createDinnerName-awed"));
    By dateCalendar = (By.cssSelector(".awe-elcont #createDinnerDate"));

    By btnChef = (By.cssSelector(".awe-lookup-field button[type= 'button']"));
    By txtChefSearch = (By.cssSelector("[data-i='createDinnerChefId-awepw'] input"));
    By btnChefOk = (By.xpath("//div[@class='o-pmc o-pu o-ddp']//div[@class='o-pbtns']//button[contains(text(),'Ok')]"));

    By btnMeals = (By.cssSelector(".awe-multilookup-field button[type= 'button']"));
    By txtMealsSearch = (By.cssSelector("#createDinnerMealsIds-awepw input"));
    By btnMealsOk = (By.xpath("//div[@data-i='createDinnerMealsIds-awepw']//button[@class='awe-btn awe-okbtn o-pbtn']"));

    By btnBonusMeal = (By.cssSelector("#createDinnerBonusMealId-awed"));
    By txtBonusMealsSearch = (By.cssSelector("[data-i='createDinnerBonusMealId'] [class='o-srcc o-ldngp'] input"));

    By btnOkPopup = (By.xpath("//div[@class='o-pbtns']//button[@class='awe-btn awe-okbtn o-pbtn']"));

    public void goToDinnerRegistrationPage(){
        _click(btnCookies, 5);
        _click(lknPopupForm, 5);
    }

    public void clkOnCreateButton(){
        _click(btnCreate, 5);
    }

    public void setName(String name){
        _clear(txtName, 5);
        _sendKeys(txtName, name, 5);
    }

    public void setDate(String date){
        _clear(dateCalendar, 5);
        _sendKeys(dateCalendar, date, 5);
    }

    public void setChef(String chef) throws InterruptedException {
        _click(btnChef, 5);
        _clear(txtChefSearch, 5);
        _sendKeys(txtChefSearch, Keys.chord(chef, Keys.ENTER), 5);
        Thread.sleep(1);
        _click((By.xpath(String.format("//li[contains(text(), '%s')]", chef))), 5);
        _click(btnChefOk, 5);
    }

    public void setMeals(String meals) throws InterruptedException {
        _click(btnMeals, 5);
        _clear(txtMealsSearch, 5);
        _sendKeys(txtMealsSearch, Keys.chord(meals, Keys.ENTER), 5);
        Thread.sleep(1);
        _click((By.xpath(String.format("//ul[@class='awe-ajaxlist awe-lookup-list awe-srl']//li[contains(text(), '%s')]//button", meals))), 5);
        _click(btnMealsOk, 5);
    }

    public void setBonusMeal(String bonusMeal){
        _click(btnBonusMeal, 5);
        _clear(txtBonusMealsSearch, 5);
        _sendKeys(txtBonusMealsSearch, bonusMeal,5);
        _click((By.xpath(String.format("//ul[@class='o-mnits']//li[contains(text(), '%s')]", bonusMeal))), 5);
    }

    public void clkOnOkButton(){
        _click(btnOkPopup, 5);
    }

    public String validateDinnerREgistration(){
        String alertText = _getAlertText(5);
        _acceptAlert(5);
        return alertText;
    }
}
