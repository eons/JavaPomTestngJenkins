package testCases;

import baseTC.BaseTC;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.UserRegistrationPage;

public class TC001_UserRegistrationTest extends BaseTC {

    @Test(groups={"master", "parabank"})
    public void verify_account_registration(){

        logger.info("***** Starting TC001_UserRegistrationTest *****");

        try {
            HomePage hp = new HomePage(driver);
            UserRegistrationPage urp = new UserRegistrationPage(driver);
            String username = (randomString() + "_" + randomFourNumbers());
            String password = randomAlphaNumberic();

            logger.info("Clicking Register hyperlink...");
            hp.clickOnRegisterLkn();

            logger.info("Providing user details...");
            urp.setFirstname("first_name");
            urp.setLastname("last_name");
            urp.setAddress("my_address");
            urp.setCity("my_city");
            urp.setState("my_state");
            urp.setZipcode(randomFiveNumbers());
            urp.setPhoneNumber(randomTenNumbers());
            urp.setSsn(randomNineNumbers());
            urp.setUsername(username);
            urp.setPassword(password);
            urp.setConfirmPassword(password);
            urp.clickRegisterButton();

            logger.info("Validating expected message...");
            if(urp.getConfirmationMsg().equals(String.format("Welcome %s", username))){
                Assert.assertTrue(true);
            }else{
                logger.error("Test failed...");
                logger.debug("Debug logs...");
                Assert.assertTrue(false);
            }
              Assert.assertEquals(urp.getConfirmationMsg(), String.format("Welcome %s", username));
        }catch(Exception e){

            Assert.fail();
        }
        logger.info("***** Finished TC001_UserRegistrationTest *****");
    }
}
