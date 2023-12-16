package com.simon.core.utils;

import com.simon.core.helps.GesturesScriptArgsHelper;
import com.simon.core.mobile.Alert;
import com.simon.core.mobile.Direction;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.Map;

@UtilityClass
public class MobileGestures {
    public static final String MOBILE_SWIPE = "mobile: swipe";
    public static final String MOBILE_SCROLL = "mobile: scroll";
    public static final String MOBILE_PINCH = "mobile: pinch";
    public static final String MOBILE_DOUBLE_TAP = "mobile: doubleTap";
    public static final String MOBILE_TOUCH_AND_HOLD = "mobile: touchAndHold";
    public static final String MOBILE_TWO_FINGER_TAP = "mobile: twoFingerTap";
    public static final String MOBILE_TAP = "mobile: tap";
    public static final String MOBILE_DRAG_FROM_TO_FOR_DURATION = "mobile: dragFromToForDuration";
    public static final String MOBILE_ALERT = "mobile: alert";

    public static IOS of(WebDriver driver) {
        return new IOS((JavascriptExecutor) driver);
    }

    public static class IOS implements com.simon.core.mobile.Gestures {
        private final JavascriptExecutor driver;

        public IOS(JavascriptExecutor driver) {
            this.driver = driver;
        }

        @Override
        public void swipe(Direction direction) {
            swipe(direction, null, null);
        }

        @Override
        public void swipe(Direction direction, Integer velocity) {
            swipe(direction, velocity, null);
        }

        @Override
        public void swipe(Direction direction, Integer velocity, RemoteWebElement element) {
            driver.executeScript(MOBILE_SWIPE, GesturesScriptArgsHelper.swipeArgs(direction, velocity, element));
        }

        @Override
        public void scroll(RemoteWebElement element, String name) {
            driver.executeScript(MOBILE_SCROLL, GesturesScriptArgsHelper.scrollWithName(element, name));
        }

        @Override
        public void scroll(String name) {
            driver.executeScript(MOBILE_SCROLL, GesturesScriptArgsHelper.scrollWithName(name));
        }

        @Override
        public void scroll(RemoteWebElement element, Direction direction) {
            driver.executeScript(MOBILE_SCROLL, GesturesScriptArgsHelper.scrollWithDirection(element, direction));
        }

        @Override
        public void scroll(Direction direction) {
            driver.executeScript(MOBILE_SCROLL, GesturesScriptArgsHelper.scrollWithDirection(direction));
        }

        @Override
        public void scrollWithPredicate(RemoteWebElement element, String predicateString) {
            driver.executeScript(MOBILE_SCROLL, GesturesScriptArgsHelper.scrollWithPredicate(element, predicateString));
        }

        @Override
        public void scrollWithPredicate(String predicateString) {
            driver.executeScript(MOBILE_SCROLL, GesturesScriptArgsHelper.scrollWithPredicate(predicateString));
        }

        @Override
        public void scroll(RemoteWebElement element, Boolean toVisible) {
            driver.executeScript(MOBILE_SCROLL, GesturesScriptArgsHelper.scrollWithToVisible(element, toVisible));
        }

        @Override
        public void scroll(Boolean toVisible) {
            driver.executeScript(MOBILE_SCROLL, GesturesScriptArgsHelper.scrollWithToVisible(toVisible));
        }

        @Override
        public void pinch(RemoteWebElement element, float scale, float velocity) {
            driver.executeScript(MOBILE_PINCH, GesturesScriptArgsHelper.pinchArgs(element, scale, velocity));
        }

        @Override
        public void pinch(float scale, float velocity) {
            driver.executeScript(MOBILE_PINCH, GesturesScriptArgsHelper.pinchArgs(scale, velocity));
        }

        @Override
        public void doubleTap(RemoteWebElement element) {
            driver.executeScript(MOBILE_DOUBLE_TAP, GesturesScriptArgsHelper.doubleTapArgs(element));
        }

        @Override
        public void doubleTap(int x, int y) {
            driver.executeScript(MOBILE_DOUBLE_TAP, GesturesScriptArgsHelper.doubleTapArgs(x, y));
        }

        @Override
        public void touchAndHold(RemoteWebElement element, int duration) {
            driver.executeScript(MOBILE_TOUCH_AND_HOLD, GesturesScriptArgsHelper.touchAndHoldArgs(element, duration));
        }

        @Override
        public void touchAndHold(int duration, int x, int y) {
            driver.executeScript(MOBILE_TOUCH_AND_HOLD, GesturesScriptArgsHelper.touchAndHoldArgs(duration, x, y));
        }

        @Override
        public void twoFingerTap(RemoteWebElement element) {
            driver.executeScript(MOBILE_TWO_FINGER_TAP, Map.of("element", element.getId()));
        }

        @Override
        public void twoFingerTap() {
            driver.executeScript(MOBILE_TWO_FINGER_TAP);
        }

        @Override
        public void tap(RemoteWebElement element, float x, float y) {
            driver.executeScript(MOBILE_TAP, GesturesScriptArgsHelper.tapArgs(element, x, y));
        }

        @Override
        public void tap(float x, float y) {
            driver.executeScript(MOBILE_TAP, GesturesScriptArgsHelper.tapArgs(x, y));
        }

        @Override
        public void dragFromToForDuration(RemoteWebElement element, float duration, float fromX, float fromY, float toX, float toY) {
            driver.executeScript(MOBILE_DRAG_FROM_TO_FOR_DURATION,
                    GesturesScriptArgsHelper.dragFromToForDurationArgs(element, duration, fromX, fromY, toX, toY));
        }

        @Override
        public void dragFromToForDuration(float duration, float fromX, float fromY, float toX, float toY) {
            driver.executeScript(MOBILE_DRAG_FROM_TO_FOR_DURATION,
                    GesturesScriptArgsHelper.dragFromToForDurationArgs(duration, fromX, fromY, toX, toY));
        }

        @Override
        public void alert(Alert action, String buttonLabel) {
            driver.executeScript(MOBILE_ALERT, Map.of("action", action.action(), "buttonLabel", buttonLabel));
        }

        @Override
        public void alert(Alert action) {
            driver.executeScript(MOBILE_ALERT, Map.of("action", action.action()));
        }
    }
}