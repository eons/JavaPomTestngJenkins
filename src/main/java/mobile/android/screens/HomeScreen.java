package mobile.android.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import mobile.android.controllers.AndroidBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeScreen extends AndroidBasePage {

    public HomeScreen(AndroidDriver androidDriver){
        super(androidDriver);
    }

    By preferenceOption = AppiumBy.accessibilityId("Preference");

    public void clickOnPreference(){
        _click(preferenceOption, 5);
    }
}
