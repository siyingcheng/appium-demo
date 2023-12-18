package com.simon.testcases.ios;

import io.appium.java_client.NoSuchContextException;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

public class IOSContextTest extends BaseIOSWebViewTest {
    @Test(groups = "WIP")
    public void testGetContext() {
        assertEquals(iosDriver.getContext(), "NATIVE_APP");
    }

    @Test(groups = "WIP")
    public void testGetContextHandles() {
        assertEquals(iosDriver.getContextHandles().size(), 2);
    }

    @Test(groups = "WIP")
    public void testSwitchContext() throws InterruptedException {
        iosDriver.getContextHandles();
        findAndSwitchToWebView();
        assertTrue(Objects.requireNonNull(iosDriver.getContext()).contains("WEBVIEW"));
        iosDriver.context("NATIVE_APP");
    }

    @Test(groups = "WIP")
    public void testContextError() {
        assertThrows(NoSuchContextException.class, () -> iosDriver.context("Planet of the Ape-ium"));
    }
}
