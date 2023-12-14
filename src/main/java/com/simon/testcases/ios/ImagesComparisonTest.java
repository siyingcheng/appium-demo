package com.simon.testcases.ios;

import com.simon.core.test.AppIOSTest;
import com.simon.utils.ScreenshotUtils;
import io.appium.java_client.imagecomparison.FeatureDetector;
import io.appium.java_client.imagecomparison.FeaturesMatchingOptions;
import io.appium.java_client.imagecomparison.FeaturesMatchingResult;
import io.appium.java_client.imagecomparison.MatchingFunction;
import io.appium.java_client.imagecomparison.OccurrenceMatchingOptions;
import io.appium.java_client.imagecomparison.OccurrenceMatchingResult;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ImagesComparisonTest extends AppIOSTest {
    @Test(groups = "ImagePlugin",
            description = "Verify image features matching success")
    public void verifyImageFeaturesMatchingSuccess() throws IOException {
        // Such comparison is useful in case the resulting image is rotated/scaled in comparison to the original one.
        byte[] screenshot = ScreenshotUtils.takeScreenshot(iosDriver);
        FeaturesMatchingResult result = iosDriver
                .matchImagesFeatures(screenshot, screenshot,
                        new FeaturesMatchingOptions()
                                .withDetectorName(FeatureDetector.ORB)
                                .withGoodMatchesFactor(40)
                                .withMatchFunc(MatchingFunction.BRUTE_FORCE_HAMMING)
                                .withEnabledVisualization());
        Assert.assertTrue(result.getVisualization().length > 0);
        Assert.assertTrue(result.getCount() > 0);
        Assert.assertTrue(result.getTotalCount() > 0);
        Assert.assertFalse(result.getPoints1().isEmpty());
        Assert.assertFalse(result.getPoints2().isEmpty());
        Assert.assertNotNull(result.getRect1());
        Assert.assertNotNull(result.getRect2());
    }

    @Test(groups = "ImagePlugin",
            description = "Verify Occurrences Search success")
    public void verifyOccurrencesSearchSuccess() {
        // Such comparison is useful in case the full image is a superset of the partial image.
        byte[] screenshot = ScreenshotUtils.takeScreenshot(iosDriver);
        OccurrenceMatchingResult result = iosDriver
                .findImageOccurrence(screenshot, screenshot, new OccurrenceMatchingOptions()
                        .withEnabledVisualization());
        Assert.assertTrue(result.getVisualization().length > 0);
        Assert.assertNotNull(result.getRect());
    }

    @Test(groups = "ImagePlugin",
            description = "Verify Similarity Calculation success")
    public void verifySimilarityCalculationSuccess() {
        byte[] screenshot = ScreenshotUtils.takeScreenshot(iosDriver);
        SimilarityMatchingResult result = iosDriver
                .getImagesSimilarity(screenshot, screenshot, new SimilarityMatchingOptions()
                        .withEnabledVisualization());
        Assert.assertTrue(result.getVisualization().length > 0);
        Assert.assertTrue(result.getScore() > 0.0d);
    }
}
