package com.simon.core.test;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public abstract class BaseMobileTest {
    protected AppiumDriverLocalService service;
    protected static final int PORT = 4723;
    protected static final String LOCAL_HOST = "127.0.0.1";
    public abstract AppiumDriverLocalService startAppiumServer();

    /**
     * Shutdown appium server and close all drivers
     */
    public abstract void afterClass();
}
