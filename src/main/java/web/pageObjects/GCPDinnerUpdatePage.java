package web.pageObjects;

import web.controllers.BasePageController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GCPDinnerUpdatePage extends BasePageController {

    public GCPDinnerUpdatePage(WebDriver driver){
        super(driver);
    }

    By btnCookies = (By.cssSelector("button[id='btnCookie']"));
    By lknGridCrud = (By.cssSelector("a[data-k='14']"));
    By containerTable = (By.cssSelector("div[class='awe-content awe-tablc'] tbody[class='awe-tbody awe-itc']"));
    By btnEdit = (By.cssSelector("td button[aria-label='edit']"));
    By txtName = (By.cssSelector("#editContentPlaceHolder1_DinnersGridName-awed"));
    By txtDate = (By.cssSelector("#editContentPlaceHolder1_DinnersGridDate"));
    By btnChefExpand = (By.xpath("//div[@class='awe-elcont'] //button[@class='awe-btn awe-openbtn awe-lkpbtn' and @aria-label='open']"));
    By txtchefSearch = (By.cssSelector("#editContentPlaceHolder1_DinnersGridChefId-awepw input[name='search']"));
    By btnChefOk = (By.xpath("//div[@class='o-pmc o-pu o-ddp']//div[@class='o-pbtns']//button[contains(text(),'Ok')]"));
    By btnMealsExpand = (By.xpath("//div[@class='awe-multilookup-field awe-field awe-hasval'] //button[@class='awe-btn awe-openbtn awe-lkpbtn']"));
    By txtMealsSearch = (By.cssSelector("#editContentPlaceHolder1_DinnersGridMealsIds-awepw input"));
    By btnMealsOk = (By.xpath("//div[@data-i='editContentPlaceHolder1_DinnersGridMealsIds-awepw']//div[@class='o-pbtns']//button[@class='awe-btn awe-okbtn o-pbtn']"));
    By btnMealsToRemoveContainer = (By.cssSelector("#editContentPlaceHolder1_DinnersGridMealsIds-awepw ul[class='awe-ajaxlist awe-lookup-list awe-sel']"));
    By btnBonusMealExpand = (By.cssSelector("#editContentPlaceHolder1_DinnersGridBonusMealId-awed"));
    By txtBonusMealSearch = (By.cssSelector("[data-i='editContentPlaceHolder1_DinnersGridBonusMealId'] [class='o-srcc o-ldngp'] input"));
    By btnOkPopup = (By.xpath("//div[@class='o-pwrap']//div[@data-i='editContentPlaceHolder1_DinnersGrid']//div[@class='o-pbtns']//button[contains(text(),'Ok')]"));

    String name, date, chef, meals = "";

    public void goToDinnerupdatePage(){
        _click(btnCookies, 5);
        _click(lknGridCrud, 5);
    }

    public void clkOnEditButton(){
        WebElement table = _findElement(containerTable);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(WebElement row : rows.subList(0, 1)){
            row.findElement(By.cssSelector("td button[aria-label='edit']")).click();
        }
    }

    public void updateName(String name){
        this.name = name;
        _clear(txtName, 5);
        _sendKeys(txtName, name, 5);
    }

    public void updateDate(String date){
        this.date= date;
        _clear(txtDate, 5);
        _sendKeys(txtDate, date, 5);
    }

    public void updateChef(String chef) throws InterruptedException {
        this.chef = chef;
        _click(btnChefExpand, 5);
        _clear(txtchefSearch, 5);
        _sendKeys(txtchefSearch, Keys.chord(chef, Keys.ENTER), 5);
        Thread.sleep(1000);
        _click((By.xpath(String.format("//li[contains(text(), '%s')]", chef))), 5);
        _click(btnChefOk, 5);
    }

    public void updateMeals(String meals) throws InterruptedException {
        this.meals = meals;
        _click(btnMealsExpand, 5);
        removeMealsPreviousOptions();
        _clear(txtMealsSearch, 5);
        _sendKeys(txtMealsSearch, Keys.chord(meals, Keys.ENTER), 5);
        Thread.sleep(1000);
        _click((By.xpath(String.format("//div[@id='editContentPlaceHolder1_DinnersGridMealsIds-awepw']//ul[@class='awe-ajaxlist awe-lookup-list awe-srl']//li[contains(text(), '%s')]//i", meals))), 5);
        _click(btnMealsOk, 5);
    }

    public void removeMealsPreviousOptions(){
        WebElement container = _findElement(btnMealsToRemoveContainer);
        List<WebElement> options = container.findElements(By.tagName("li"));
        for(WebElement option : options){
            _click((By.cssSelector("#editContentPlaceHolder1_DinnersGridMealsIds-awepw ul[class='awe-ajaxlist awe-lookup-list awe-sel'] li i")), 5);
        }
    }

    public void updateBonusMeal(String bonusMeal){
        _click(btnBonusMealExpand, 5);
        _clear(txtBonusMealSearch, 5);
        _sendKeys(txtBonusMealSearch, bonusMeal, 5);
        _click((By.xpath(String.format("//div[@id='editContentPlaceHolder1_DinnersGridBonusMealId-dropmenu']//ul//li[contains(text(), '%s')]", bonusMeal))), 5);
    }

    public void clkOkUpdateButton(){
        _click(btnOkPopup, 5);
    }

    public boolean isDinnerUpdated(){
        String expectedValue = this.name + this.date + this.chef + this.meals;
        System.out.println("Expected value: " + expectedValue);
        String currentValue = getRegistrationUpdated();
        System.out.println("Current value: " + currentValue);
        if (expectedValue.equals(currentValue)){
            return true;
        }else{
            return false;
        }
    }

    public String getRegistrationUpdated(){
        WebElement table = _findElement(containerTable);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        StringBuilder currentValue = new StringBuilder();
        for(WebElement row : rows.subList(0, 1)){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for(WebElement cell : cells.subList(1, 5)){
                System.out.println("get text: " + cell.getText());
                currentValue.append(cell.getText());
            }
        }
        return currentValue.toString();
    }
}
