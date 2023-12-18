package com.simon.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AppUtils {
    // Demo app from: https://github.com/saucelabs/my-demo-app-rn/releases/tag/v1.3.0
    private static final String ANDROID_APP = "Android-MyDemoAppRN.1.3.0.build-244.apk";
    private static final String IOS_APP = "iOS-Simulator-MyRNDemoApp.1.3.0-162.zip";
    private static final String IOS_NATIVE_DEMO_APP = "iOS-Simulator-NativeDemoApp-0.4.0.app.zip";
    public static final String BASE_PATH = System.getProperty("user.dir");
    public static final String APPS_PATH = BASE_PATH + "/apps/";

    public static String getAndroidApp() {
        return APPS_PATH + ANDROID_APP;
    }

    public static String getIosApp() {
        return APPS_PATH + IOS_APP;
    }

    public static String getIosNativeDemoApp() {
        return APPS_PATH + IOS_NATIVE_DEMO_APP;
    }
}
