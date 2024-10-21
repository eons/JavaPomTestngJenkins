package web.testCases;

import web.baseTC.BaseTC;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.pageObjects.HomePage;
import utilities.DataProvidersUtility;

public class TC005_LoginValidationDDTest extends BaseTC {
    @Test(dataProvider="customerData", dataProviderClass= DataProvidersUtility.class, groups={"master", "dataProvider", "parabank"})
    public void loginValidation(String username, String password, String exp){

        logger.info("***** Starting TC005_LoginValidationDDTest *****");

        try {
            HomePage hp = new HomePage(driver);

            hp.setUsername(username);
            hp.setPassword(password);
            hp.clickOnLoginButton();
            boolean msg = hp.isMyAccountExist();

            if (exp.equalsIgnoreCase("pass")) {
                if (msg == true) {
                    //hp.clickOnLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }

            if (exp.equalsIgnoreCase("fail")) {
                if (msg == true) {
                    //hp.clickOnLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        }catch(Exception e){
            Assert.fail();
        }
        logger.info("***** Ending TC005_LoginValidationDDTest *****");
    }
}
