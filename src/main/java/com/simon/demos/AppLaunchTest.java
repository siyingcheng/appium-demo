package com.simon.demos;

import com.simon.pages.android.AndroidHomePage;
import com.simon.pages.ios.IOSHomePage;
import com.simon.utils.AppUtils;
import com.simon.utils.DriverUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppLaunchTest {

    @Test
    public void androidLaunchTest() {
        var options = new UiAutomator2Options();
        options.setDeviceName("simon-auto-test");
        options.setApp(AppUtils.getAndroidApp());

        var driver = new AndroidDriver(DriverUtils.driverUrl(), options);
        var homePage = new AndroidHomePage(driver);
        Assert.assertTrue(homePage.isDisplay(), "Verify app launch success");
    }

    @Test
    public void iosLaunchTest() throws InterruptedException {
        var options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
        options.setApp(AppUtils.getIosApp());

        var driver = new IOSDriver(DriverUtils.driverUrl(), options);
        var homePage = new IOSHomePage(driver);
        Assert.assertTrue(homePage.isDisplay(), "Verify app launch success");
    }
}
