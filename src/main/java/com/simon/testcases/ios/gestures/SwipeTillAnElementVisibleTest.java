package com.simon.testcases.ios.gestures;

import com.simon.core.mobile.Direction;
import com.simon.core.test.IOSGesturesTest;
import com.simon.core.utils.FingerGestureUtils;
import com.simon.core.utils.MobileGestures;
import com.simon.pages.ios.NativeAppNavigator;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import static com.simon.core.utils.FingerGestureUtils.Direction.UP;
import static org.testng.AssertJUnit.assertTrue;

public class SwipeTillAnElementVisibleTest extends IOSGesturesTest {

    @Test(groups = {"NativeApp", "Gestures"}, description = "Swipe till an element visible by driver.perform")
    public void testSwipeTillElementVisible() {
        var navigator = new NativeAppNavigator(iosDriver);
        var swipePage = navigator.navigateToSwipePage();
        var fingerGestureUtils = new FingerGestureUtils(iosDriver);

        int maxSwipeCount = 5;
        while (maxSwipeCount > 0 && !swipePage.getRobotImage().isDisplayed()) {
            fingerGestureUtils.swipe(UP, 200);
            maxSwipeCount--;
        }

        assertTrue(swipePage.getRobotImage().isDisplayed());
    }

    @Test(groups = {"NativeApp", "Gestures"}, description = "Swipe till an element visible by execute W3C script")
    public void testSwipeTillElementVisibleUsingScript() {
        var navigator = new NativeAppNavigator(iosDriver);
        var swipePage = navigator.navigateToSwipePage();

        // way 1:
//        MobileGestures.of(iosDriver)
//                .scroll(Direction.DOWN);

        // way 2:
        while (!swipePage.getRobotImage().isDisplayed()) {
            MobileGestures.of(iosDriver)
                    .swipe(Direction.UP);

            assertTrue(swipePage.getRobotImage().isDisplayed());
        }
    }

    // Only Android
    @Test(groups = {"NativeApp", "Gestures", "OnlyAndroid"}, description = "Swipe till an element visible by UiAutomator")
    public void testSwipeTillElementVisibleUsingUiAutomator() {
        var navigator = new NativeAppNavigator(iosDriver);
        var swipePage = navigator.navigateToSwipePage();

        final var scrolledLogo = AppiumBy.androidUIAutomator(
                """
                        new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description("WebdriverIO logo"));
                        """);

        iosDriver.findElement(scrolledLogo);

        assertTrue(swipePage.getRobotImage().isDisplayed());
    }

}
