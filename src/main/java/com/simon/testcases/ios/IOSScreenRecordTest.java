package com.simon.testcases.ios;

import com.simon.core.test.AppIOSTest;
import io.appium.java_client.ios.IOSStartScreenRecordingOptions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Base64;

import static org.testng.Assert.assertFalse;

public class IOSScreenRecordTest extends AppIOSTest {
    @Test()
    public void verifyBasicScreenRecordingWorks() throws InterruptedException, IOException {
        iosDriver.startRecordingScreen(
                new IOSStartScreenRecordingOptions()
                        .withTimeLimit(Duration.ofSeconds(10))
        );
        Thread.sleep(5000);
        String result = iosDriver.stopRecordingScreen();
        // save video
//        byte[] video = Base64.getDecoder().decode(result);
//        Files.write(Path.of("video.mp4"), video);
        assertFalse(result.isEmpty());

    }
}
