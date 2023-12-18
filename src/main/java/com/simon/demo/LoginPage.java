package com.simon.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.function.Consumer;

public class LoginPage implements IMyDriverWithLambda {

    private static final long DEFAULT_TIMEOUT = 10;
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login");
    private By messageText = By.id("message");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        setTimeout(t -> t.implicitlyWait(Duration.ofSeconds(DEFAULT_TIMEOUT)));
        setTimeout(t -> t.pageLoadTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT)));
        setTimeout(t -> t.scriptTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT)));
    }

    @Override
    public WebDriver getDriver() {
        return this.driver;
    }

    public void login(String username, String password) {
        performAction(this.usernameInput, e -> e.sendKeys(username));
        performAction(this.passwordInput, e -> e.sendKeys(password));
        performAction(this.loginButton, WebElement::click);
        final var message = getPerformAction(this.messageText, WebElement::getText);
        System.out.println(message);
    }
}
