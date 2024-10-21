package mobile.android;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;


public class AppiumBasics extends BaseTest{

    @Test
    public void firstAppiumTest() {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
    }
}
