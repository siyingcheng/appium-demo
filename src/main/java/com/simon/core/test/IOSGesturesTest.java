package com.simon.core.test;

import com.simon.utils.AppUtils;
import com.simon.utils.ServiceUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.SessionNotCreatedException;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class IOSGesturesTest extends BaseIOSTest {

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        var options = new XCUITestOptions()
                .setPlatformVersion(PLATFORM_VERSION)
                .setDeviceName(DEVICE_NAME)
                .setCommandTimeouts(Duration.ofMinutes(4))
                .setApp(AppUtils.getIosNativeDemoApp())
                // WDA -> Web Driver Agent
                .setWdaLaunchTimeout(WDA_LAUNCH_TIMEOUT);
        try {
            iosDriver = new IOSDriver(ServiceUtils.getUrl(), options);
        } catch (SessionNotCreatedException e) {
            options.useNewWDA();
            iosDriver = new IOSDriver(ServiceUtils.getUrl(), options);
        }
    }
}
