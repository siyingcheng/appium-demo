package com.simon.testcases.ios;

import com.simon.core.test.AppIOSTest;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class IOSSyslogListenerTest extends AppIOSTest {

    @Test(groups = "WIP")
    public void verifySyslogListenerCanBeAssigned() {
        final Semaphore messageSemaphore = new Semaphore(1);
        final Duration timeout = Duration.ofSeconds(15);

        iosDriver.addSyslogMessagesListener(msg -> messageSemaphore.release());
        iosDriver.addSyslogConnectionListener(() -> System.out.println("Connected to the web socket"));
        iosDriver.addSyslogDisconnectionListener(() -> System.out.println("Disconnected from the web socket"));
        iosDriver.addSyslogErrorsListener(Throwable::printStackTrace);
        try {
            iosDriver.startSyslogBroadcast();
            messageSemaphore.acquire();
            // This is needed for pushing some internal log messages
            iosDriver.runAppInBackground(Duration.ofSeconds(1));
            assertTrue(messageSemaphore.tryAcquire(timeout.toMillis(), TimeUnit.MILLISECONDS),
                    String.format("Didn't receive any log message after %s timeout",
                            DurationFormatUtils.formatDuration(timeout.toMillis(), "H:mm:ss", true)));
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        } finally {
            messageSemaphore.release();
            iosDriver.stopSyslogBroadcast();
        }
    }
}
