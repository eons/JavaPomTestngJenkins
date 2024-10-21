package mobile.android.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import mobile.android.controllers.AndroidBasePage;
import org.openqa.selenium.By;

public class PreferenceDependenciesScreen extends AndroidBasePage {

    public PreferenceDependenciesScreen(AndroidDriver androidDriver){
        super(androidDriver);
    }

    By wifiCheckbox = AppiumBy.id("android:id/checkbox");
    By wifiSettingsOption = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]");
    By wifiSettingsRTextBox = AppiumBy.id("android:id/edit");
    By okButton = AppiumBy.id("android:id/button1");

    public void clickOnWifiCheckbox(){
        _click(wifiCheckbox, 5);
    }

    public void clickOnWifiSettingsOption(){
        _click(wifiSettingsOption, 5);
    }

    public void setOnWifiSettingsTextBox(){
        _sendKeys(wifiSettingsRTextBox, "MyWifi", 5);
    }

    public void clickOnOkButton(){
        _click(okButton, 5);
    }
}
