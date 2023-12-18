package com.simon.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Consumer;
import java.util.function.Function;

public interface IMyDriverWithLambda {
    WebDriver getDriver();

    default void setTimeout(final Consumer<WebDriver.Timeouts> timeout) {
        timeout.accept(getDriver().manage().timeouts());
    }

    default void performAction(final By locator, Consumer<WebElement> action) {
        action.accept(getDriver().findElement(locator));
    }

    default <T> T getPerformAction(By messageText, Function<WebElement, T> action) {
        return action.apply(getDriver().findElement(messageText));
    }
}
