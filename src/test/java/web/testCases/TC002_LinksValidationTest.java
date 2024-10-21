package web.testCases;

import web.baseTC.BaseTC;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import web.pageObjects.HomePage;

import java.io.IOException;

public class TC002_LinksValidationTest extends BaseTC {

    @Test(groups={"master", "parabank"})
    public void validatesLeftMenulnks() throws IOException, ParseException, InterruptedException {
        logger.info("***** Starting TC002_LinksValidationTest *****");
        HomePage hp = new HomePage(driver);

        hp.createsListOfLinks();
        logger.info("***** Ending TC002_LinksValidationTest *****");
    }
}
