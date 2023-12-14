package com.simon.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Base64;

@UtilityClass
public class ScreenshotUtils {
    public static byte[] takeScreenshot(TakesScreenshot driver) {
        return Base64.getEncoder().encode(driver.getScreenshotAs(OutputType.BYTES));
    }
}
