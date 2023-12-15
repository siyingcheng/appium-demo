package com.simon.testcases.ios;

import com.simon.core.test.AppIOSTest;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RotationTest extends AppIOSTest {

    @AfterMethod
    public void afterMethod() {
        iosDriver.rotate(new DeviceRotation(0, 0, 0));
    }

    @Test(groups = "WIP")
    public void testLandscapeRightRotation() {
        DeviceRotation landscapeRightRotation = new DeviceRotation(0, 0, 90);
        iosDriver.rotate(landscapeRightRotation);
        assertEquals(iosDriver.rotation(), landscapeRightRotation);
    }

    @Test(groups = "WIP")
    public void testLandscapeLeftRotation() {
        DeviceRotation landscapeLeftRotation = new DeviceRotation(0, 0, 270);
        iosDriver.rotate(landscapeLeftRotation);
        assertEquals(iosDriver.rotation(), landscapeLeftRotation);
    }
}
