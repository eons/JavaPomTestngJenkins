package mobile.android;

import io.appium.java_client.AppiumBy;
import mobile.android.screens.HomeScreen;
import mobile.android.screens.PreferenceDependenciesScreen;
import mobile.android.screens.PreferenceScreen;
import org.testng.annotations.Test;


public class AppiumBasics extends BaseTest{

    @Test
    public void firstAppiumTest() {
        HomeScreen homeScreen = new HomeScreen(driver);
        PreferenceScreen preferenceScreen = new PreferenceScreen(driver);
        PreferenceDependenciesScreen preferenceDependenciesScreen = new PreferenceDependenciesScreen(driver);

        homeScreen.clickOnPreference();
        preferenceScreen.clickOnPreferenceDependencies();
        preferenceDependenciesScreen.clickOnWifiCheckbox();
        preferenceDependenciesScreen.clickOnWifiSettingsOption();
        preferenceDependenciesScreen.setOnWifiSettingsTextBox();
        preferenceDependenciesScreen.clickOnOkButton();
    }
}
