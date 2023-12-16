package com.simon.core.mobile;

import org.openqa.selenium.remote.RemoteWebElement;

public interface Gestures {
    void swipe(Direction direction);

    void swipe(Direction direction, Integer velocity);

    void swipe(Direction direction, Integer velocity, RemoteWebElement element);

    void scroll(RemoteWebElement element, String name);

    void scroll(String name);

    void scroll(RemoteWebElement element, Direction direction);

    void scroll(Direction direction);

    void scrollWithPredicate(RemoteWebElement element, String predicateString);

    void scrollWithPredicate(String predicateString);

    void scroll(RemoteWebElement element, Boolean toVisible);

    void scroll(Boolean toVisible);

    void pinch(RemoteWebElement element, float scale, float velocity);

    void pinch(float scale, float velocity);

    void doubleTap(RemoteWebElement element);

    void doubleTap(int x, int y);

    void touchAndHold(RemoteWebElement element, int duration);

    void touchAndHold(int duration, int x, int y);

    void twoFingerTap(RemoteWebElement element);

    void twoFingerTap();

    void tap(RemoteWebElement element, float x, float y);

    void tap(float x, float y);

    void dragFromToForDuration(RemoteWebElement element, float duration, float fromX, float fromY, float toX, float toY);

    void dragFromToForDuration(float duration, float fromX, float fromY, float toX, float toY);

    void alert(Alert action, String buttonLabel);

    void alert(Alert action);
}
