package com.simon.core.test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import java.time.Duration;
import java.util.Objects;

public class BaseIOSTest extends BaseMobileTest {
    public static final Duration WDA_LAUNCH_TIMEOUT = Duration.ofMinutes(4);
    public static final String DEVICE_NAME = Objects.nonNull(System.getenv("IOS_DEVICE_NAME"))
            ? System.getenv("IOS_DEVICE_NAME")
            : "iPhone 15";
    public static final String PLATFORM_VERSION = Objects.nonNull(System.getenv("IOS_PLATFORM_VERSION"))
            ? System.getenv("IOS_PLATFORM_VERSION")
            : "17.0";
    public static final Duration SERVER_START_TIMEOUT = Duration.ofMillis(3);
    protected IOSDriver iosDriver;

    public synchronized AppiumDriverLocalService startAppiumServer() {
        if (Objects.isNull(service)) {
            service = new AppiumServiceBuilder()
                    .withIPAddress(LOCAL_HOST)
                    .usingPort(PORT)
                    .withTimeout(SERVER_START_TIMEOUT)
                    .build();
            service.start();
        } else if (!service.isRunning()) {
            service.start();
        }
        return service;
    }

    @Override
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (Objects.nonNull(iosDriver)) {
            iosDriver.quit();
        }
        if (Objects.nonNull(service) && service.isRunning()) {
            service.stop();
        }
    }

    public WebDriverWait getWait(Duration duration) {
        return new WebDriverWait(iosDriver, duration);
    }
}
