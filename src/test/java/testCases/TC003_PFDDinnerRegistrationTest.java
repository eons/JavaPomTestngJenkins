package testCases;

import baseTC.BaseTC;
import org.testng.annotations.Test;
import pageObjects.PFDDinnerRegistrationPage;

public class TC003_PFDDinnerRegistrationTest extends BaseTC {

    @Test(groups={"master", "demowf"})
    public void DinnerRegistration() throws InterruptedException {
        logger.info("***** Starting TC003_PFDDinnerRegistrationTest *****");
        PFDDinnerRegistrationPage dr = new PFDDinnerRegistrationPage(driver);

        dr.goToDinnerRegistrationPage();
        dr.clkOnCreateButton();
        dr.setName(randomString());
        dr.setDate(randomDate());
        dr.setChef("Josh Baskin");
        dr.setMeals("Rice");
        dr.setBonusMeal("Papaya");
        dr.clkOnOkButton();
        logger.info("***** Ending TC003_PFDDinnerRegistrationTest *****");
    }
}
