package web.pageObjects;

import web.controllers.BasePageController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserRegistrationPage extends BasePageController {

    // ======= rightPanel =======
    By txtFirstname = By.cssSelector("#rightPanel input[id= 'customer.firstName']");
    By txtLastname = By.cssSelector("#rightPanel input[id= 'customer.lastName']");
    By txtAddress = By.cssSelector("#rightPanel input[id= 'customer.address.street']");
    By txtCity = By.cssSelector("#rightPanel input[id= 'customer.address.city']");
    By txtState = By.cssSelector("#rightPanel input[id= 'customer.address.state']");
    By txtZipcode = By.cssSelector("#rightPanel input[id= 'customer.address.zipCode']");
    By txtPhoneNumber = By.cssSelector("#rightPanel input[id= 'customer.phoneNumber']");
    By txtSsn = By.cssSelector("#rightPanel input[id= 'customer.ssn']");
    By txtUsernameRightPanel = By.cssSelector("#rightPanel input[id= 'customer.username']");
    By txtPasswordRightPanel = By.cssSelector("#rightPanel input[id= 'customer.password']");
    By txtConfirmPassword = By.cssSelector("#rightPanel input[id= 'repeatedPassword']");
    By btnRegisterRightPanel = By.cssSelector("#rightPanel input[value= 'Register']");
    By msgWelcome = By.cssSelector("h1[class='title']");


    public UserRegistrationPage(WebDriver driver){
        super(driver);
    }

    public void setFirstname(String fname){
        _sendKeys(txtFirstname, fname, 5);
    }

    public void setLastname(String lname){
        _sendKeys(txtLastname, lname, 5);
    }

    public void setAddress(String address){
        _sendKeys(txtAddress, address, 5);
    }

    public void setCity(String city){
        _sendKeys(txtCity, city, 5);
    }

    public void setState(String state){
        _sendKeys(txtState, state, 5);
    }

    public void setZipcode(String zipcode){
        _sendKeys(txtZipcode, zipcode, 5);
    }

    public void setPhoneNumber(String phone){
        _sendKeys(txtPhoneNumber, phone, 5);
    }

    public void setSsn(String ssn){
        _sendKeys(txtSsn, ssn, 5);
    }

    public void setUsername(String username){
        _sendKeys(txtUsernameRightPanel, username, 5);
    }

    public void setPassword(String password){
        _sendKeys(txtPasswordRightPanel, password, 5);
    }

    public void setConfirmPassword(String password){
        _sendKeys(txtConfirmPassword, password, 5);
    }

    public void clickRegisterButton(){
        _click(btnRegisterRightPanel, 5);
    }

    public String getConfirmationMsg(){
        try{
            return _getText(msgWelcome, 5);
        } catch (Exception e){
            return (e.getMessage());
        }
    }
}
