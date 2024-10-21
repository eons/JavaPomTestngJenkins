package mobile.android.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import mobile.android.controllers.AndroidBasePage;
import org.openqa.selenium.By;

public class PreferenceScreen extends AndroidBasePage {

    public PreferenceScreen(AndroidDriver androidDriver){
        super(androidDriver);
    }

    By preferenceDependenciesOption = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]");

    public void clickOnPreferenceDependencies(){
        _click(preferenceDependenciesOption, 5);
    }

}
