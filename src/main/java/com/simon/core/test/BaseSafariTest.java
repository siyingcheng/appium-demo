package com.simon.core.test;

import com.simon.utils.ServiceUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.MobileBrowserType;
import org.testng.annotations.BeforeClass;

public class BaseSafariTest extends BaseIOSTest {
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
//        startAppiumServer();

        XCUITestOptions options = new XCUITestOptions()
                .withBrowserName(MobileBrowserType.SAFARI)
                .setDeviceName(DEVICE_NAME)
                .setPlatformVersion(PLATFORM_VERSION)
                .setWdaLaunchTimeout(WDA_LAUNCH_TIMEOUT);
        iosDriver = new IOSDriver(ServiceUtils.getUrl(), options);
    }
}
