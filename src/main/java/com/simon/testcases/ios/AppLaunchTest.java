package com.simon.testcases.ios;

import com.simon.core.test.AppIOSTest;
import com.simon.pages.ios.IOSHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppLaunchTest extends AppIOSTest {
    @Test(groups = "P0", description = "Verify ios app launch success")
    public void verifyIosAppLaunchSuccess() {
        var homePage = new IOSHomePage(iosDriver);

        Assert.assertTrue(homePage.isDisplay(), "Verify app launch success");
    }
}
