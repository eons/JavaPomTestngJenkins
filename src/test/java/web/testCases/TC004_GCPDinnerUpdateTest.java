package web.testCases;

import web.baseTC.BaseTC;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.pageObjects.GCPDinnerUpdatePage;

public class TC004_GCPDinnerUpdateTest extends BaseTC {

    @Test(groups={"master", "demowf"})
    public void dinnerUpdate() throws InterruptedException {
        logger.info("***** Starting TC004_GCPDinnerUpdateTest *****");
        GCPDinnerUpdatePage gc = new GCPDinnerUpdatePage(driver);

        gc.goToDinnerupdatePage();
        gc.clkOnEditButton();
        gc.updateName("YMEyz");
        gc.updateDate("8/3/2024");
        gc.updateChef("Pepper Tomato");
        gc.updateMeals("Mango");
        gc.updateBonusMeal("Banana");
        gc.clkOkUpdateButton();
        Assert.assertTrue(gc.isDinnerUpdated());
        logger.info("***** Ending TC004_GCPDinnerUpdateTest *****");
    }
}
