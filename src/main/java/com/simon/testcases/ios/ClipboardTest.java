package com.simon.testcases.ios;

import com.simon.core.test.AppIOSTest;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class ClipboardTest extends AppIOSTest {
    @Test(groups = "Regression", description = "Verify set and get clipboard text success")
    public void verifySetAndGetClipboardTextSuccess() {
        final String text = "Hello testing...";
        iosDriver.setClipboardText(text);
        assertEquals(iosDriver.getClipboardText(), text, "Verify text content on clipboard is correct");
    }

    @Test(groups = "Regression", description = "Verify set and get clipboard image success")
    public void verifySetAndGetClipboardImageSuccess() throws IOException {
        final URL fileNameOrUrl = URI
                .create("https://static.vecteezy.com/system/resources/previews/000/288/123/original/administration-vector-icon.jpg")
                .toURL();
        BufferedImage bufferedImage = ImageIO.read(fileNameOrUrl);
        iosDriver.setClipboardImage(bufferedImage);
        BufferedImage clipboardImage = iosDriver.getClipboardImage();
        assertEquals(clipboardImage.getWidth(), bufferedImage.getWidth(null), "Verify image width on clipboard is correct");
        assertEquals(clipboardImage.getHeight(), bufferedImage.getHeight(null), "Verify image height on clipboard is correct");
    }

    @Test(groups = "Regression", description = "Verify set and get clipboard URL success")
    public void verifySetAndGetClipboardUrlSuccess() throws IOException {
        final URL url = URI
                .create("https://static.vecteezy.com/system/resources/previews/000/288/123/original/administration-vector-icon.jpg")
                .toURL();
        iosDriver.setClipboardUrl(url);
        URL clipboardUrl = iosDriver.getClipboardUrl();
        assertEquals(clipboardUrl, url, "Verify URL on clipboard is correct");
    }
}
