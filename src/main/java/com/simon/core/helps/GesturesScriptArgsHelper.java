package com.simon.core.helps;

import com.simon.core.mobile.Direction;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GesturesScriptArgsHelper {
    public static Map<String, Object> swipeArgs(Direction direction, Integer velocity, RemoteWebElement element) {
        if (Objects.nonNull(element)) {
            return nullValueMap("direction", direction.direction(), "velocity", velocity, "element", element.getId());
        }
        return nullValueMap("direction", direction.direction(), "velocity", velocity);
    }

    private static Map<String, Object> nullValueMap(Object... args) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            String key = (String) args[i];
            Object value = args[i + 1];
            if (Objects.nonNull(value)) {
                map.put(key, value);
            }
        }
        return map;
    }

    public static Map<String, Object> scrollWithName(RemoteWebElement element, String name) {
        return Map.of("element", element.getId(), "name", name);
    }

    public static Map<String, Object> scrollWithName(String name) {
        return Map.of("name", name);
    }

    public static Map<String, Object> scrollWithDirection(RemoteWebElement element, Direction direction) {
        return Map.of("element", element.getId(), "direction", direction.direction());
    }

    public static Map<String, Object> scrollWithDirection(Direction direction) {
        return Map.of("direction", direction.direction());
    }

    public static Map<String, Object> scrollWithPredicate(RemoteWebElement element, String predicateString) {
        return Map.of("element", element.getId(), "predicateString", predicateString);
    }

    public static Map<String, Object> scrollWithPredicate(String predicateString) {
        return Map.of("predicateString", predicateString);
    }

    public static Map<String, Object> scrollWithToVisible(RemoteWebElement element, Boolean toVisible) {
        return Map.of("element", element.getId(), "toVisible", toVisible);
    }

    public static Map<String, Object> scrollWithToVisible(Boolean toVisible) {
        return Map.of("toVisible", toVisible);
    }

    public static Map<String, Object> pinchArgs(RemoteWebElement element, float scale, float velocity) {
        return Map.of("element", element.getId(), "scale", scale, "velocity", velocity);
    }

    public static Map<String, Object> pinchArgs(float scale, float velocity) {
        return Map.of("scale", scale, "velocity", velocity);
    }

    public static Map<String, Object> doubleTapArgs(RemoteWebElement element) {
        return Map.of("element", element.getId());
    }

    public static Map<String, Object> doubleTapArgs(int x, int y) {
        return Map.of("x", x, "y", y);
    }

    public static Map<String, Object> touchAndHoldArgs(RemoteWebElement element, int duration) {
        return Map.of("element", element.getId(), "duration", duration);
    }

    public static Map<String, Object> touchAndHoldArgs(int duration, int x, int y) {
        return Map.of("duration", duration, "x", x, "y", y);
    }

    public static Map<String, Object> tapArgs(RemoteWebElement element, float x, float y) {
        return Map.of("element", element.getId(), "x", x, "y", y);
    }

    public static Map<String, Object> tapArgs(float x, float y) {
        return Map.of("x", x, "y", y);
    }

    public static Map<String, Object> dragFromToForDurationArgs(RemoteWebElement element, float duration, float fromX, float fromY, float toX, float toY) {
        return Map.of("element", element.getId(), "duration", duration, "fromX", fromX, "fromY", fromY, "toX", toX, "toY", toY);
    }

    public static Map<String, Object> dragFromToForDurationArgs(float duration, float fromX, float fromY, float toX, float toY) {
        return Map.of("duration", duration, "fromX", fromX, "fromY", fromY, "toX", toX, "toY", toY);
    }
}
