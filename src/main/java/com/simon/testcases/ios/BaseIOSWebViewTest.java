package com.simon.testcases.ios;

import com.simon.core.test.BaseIOSTest;
import com.simon.utils.ServiceUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.SessionNotCreatedException;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.function.Supplier;

import static com.simon.utils.TestResourcesUtils.vodQaAppZip;

public class BaseIOSWebViewTest extends BaseIOSTest {
    private static final Duration WEB_VIEW_DETECT_INTERVAL = Duration.ofSeconds(1);
    private static final Duration WEB_VIEW_DETECT_DURATION = Duration.ofSeconds(15);

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
//        startAppiumServer();

        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName(DEVICE_NAME)
                .setWdaLaunchTimeout(WDA_LAUNCH_TIMEOUT)
                .setCommandTimeouts(Duration.ofSeconds(240))
                .setApp(vodQaAppZip().toAbsolutePath().toString());
//        Supplier<IOSDriver> createDriver = () -> new IOSDriver(service.getUrl(), options);
        Supplier<IOSDriver> createDriver = () -> new IOSDriver(ServiceUtils.getUrl(), options);
        try {
            iosDriver = createDriver.get();
        } catch (SessionNotCreatedException e) {
            // Sometimes WDA session creation freezes unexpectedly on CI:
            // https://dev.azure.com/srinivasansekar/java-client/_build/results?buildId=356&view=ms.vss-test-web.build-test-results-tab
            options.useNewWDA();
            iosDriver = createDriver.get();
        }
    }

    protected void findAndSwitchToWebView() throws InterruptedException {
        final long msStarted = System.currentTimeMillis();
        while (System.currentTimeMillis() - msStarted <= WEB_VIEW_DETECT_DURATION.toMillis()) {
            for (String handle : iosDriver.getContextHandles()) {
                if (handle.contains("WEBVIEW")) {
                    iosDriver.context(handle);
                    return;
                }
            }
            //noinspection BusyWait
            Thread.sleep(WEB_VIEW_DETECT_INTERVAL.toMillis());
        }
        throw new IllegalStateException(String.format("No web views have been detected within %sms timeout",
                WEB_VIEW_DETECT_DURATION.toMillis()));
    }
}
