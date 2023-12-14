package com.simon.testcases.android;

import com.simon.pages.android.AndroidHomePage;
import com.simon.utils.AppUtils;
import com.simon.utils.ServiceUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppLaunchTest {
    @Test(groups = "P0", description = "Verify ios app launch success")
    public void androidLaunchTest() {
        var options = new UiAutomator2Options();
        options.setDeviceName("simon-auto-test");
        options.setApp(AppUtils.getAndroidApp());

        var driver = new AndroidDriver(ServiceUtils.getUrl(), options);
        var homePage = new AndroidHomePage(driver);
        Assert.assertTrue(homePage.isDisplay(), "Verify app launch success");
    }
}
