package com.simon.core.utils;

import io.appium.java_client.AppiumDriver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.util.List;
import java.util.Objects;

import static com.simon.core.utils.FingerGestureUtils.Direction.LEFT;
import static com.simon.core.utils.FingerGestureUtils.Direction.RIGHT;
import static java.time.Duration.ZERO;
import static java.time.Duration.ofMillis;
import static java.util.Collections.singleton;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

@AllArgsConstructor
public class FingerGestureUtils<D extends AppiumDriver> {
    private static final String FINGER_1 = "Finger 1";
    private static final String FINGER_2 = "Finger 2";

    private D driver;

    @AllArgsConstructor
    @Getter
    public enum Direction {
        LEFT(-1, 0),
        RIGHT(1, 0),
        UP(0, -1),
        DOWN(0, 1);

        private final int x;
        private final int y;
    }

    public void zoomOut(final WebElement element, int distance) {
        final var start = getSwipeStartPosition(element);
        final var start1 = new Point(start.getX() - 50, start.getY());
        final var start2 = new Point(start.getX() + 50, start.getY());

        final var end1 = getSwipeEndPosition(RIGHT, element, distance);
        final var end2 = getSwipeEndPosition(LEFT, element, distance);

        final var sequence1 = singleFingerSwipe(FINGER_1, 0, end1, start1);
        final var sequence2 = singleFingerSwipe(FINGER_2, 0, end2, start2);
        this.driver.perform(List.of(sequence1, sequence2));
    }

    public void zoomIn(final WebElement element, int distance) {
        final var start = getSwipeStartPosition(element);
        final var start1 = new Point(start.getX() - 50, start.getY());
        final var start2 = new Point(start.getX() + 50, start.getY());

        final var end1 = getSwipeEndPosition(RIGHT, element, distance);
        final var end2 = getSwipeEndPosition(LEFT, element, distance);

        final var sequence1 = singleFingerSwipe(FINGER_1, 0, start1, end1);
        final var sequence2 = singleFingerSwipe(FINGER_2, 0, start2, end2);
        this.driver.perform(List.of(sequence1, sequence2));
    }

    public void dragTo(final WebElement source, final WebElement target) {
        final var start = getElementCenter(source);
        final var end = getElementCenter(target);

        final var sequence = singleFingerSwipe(FINGER_1, 0, start, end);
        this.driver.perform(singleton(sequence));
    }

    public void tap(final WebElement element) {
        final var start = getElementCenter(element);
        final var sequence = singleFingerSwipe(FINGER_1, 0, start, null);

        this.driver.perform(singleton(sequence));
    }

    public void swipe(final Direction direction, int distance) {
        swipe(direction, null, distance);
    }

    public void swipe(final Direction direction, final WebElement element, int distance) {
        final var start = getSwipeStartPosition(element);
        final var end = getSwipeEndPosition(direction, element, distance);

        final var sequence = singleFingerSwipe(FINGER_1, 0, start, end);
        this.driver.perform(singleton(sequence));
    }

    private Sequence singleFingerSwipe(final String fingerName, final int index, final Point start, final Point end) {
        final var finger = new PointerInput(TOUCH, fingerName);
        final var sequence = new Sequence(finger, index);

        sequence.addAction(finger.createPointerMove(ZERO, viewport(), start.getX(), start.getY()));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        if (Objects.nonNull(end)) {
            sequence.addAction(new Pause(finger, ofMillis(500)));
            sequence.addAction(finger.createPointerMove(ofMillis(500), viewport(), end.getX(), end.getY()));
        }

        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        return sequence;
    }


    private Point getSwipeEndPosition(final Direction direction, final WebElement element, final int distance) {
        verifyDistance(distance);
        final var start = getSwipeStartPosition(element);
        final var x = start.getX() + (direction.getX() * direction.getX() * distance / 100);
        final var y = start.getY() + (direction.getY() * direction.getY() * distance / 100);
        return getCorrectedCoordinates(element, new Point(x, y));
    }

    private void verifyDistance(int distance) {
        if (distance <= 0 || distance >= 100) {
            throw new IllegalArgumentException("Distance must be between 0 and 100 exclusive...");
        }
    }

    private Point getSwipeStartPosition(final WebElement element) {
        final var screenSize = getScreenSize();
        int x;
        int y;
        if (Objects.nonNull(element)) {
            final var center = getElementCenter(element);
            x = center.getX();
            y = center.getY();
        } else {
            x = screenSize.getWidth() / 2;
            y = screenSize.getHeight() / 2;
        }
        return new Point(x, y);
    }

    private Point getElementCenter(final WebElement element) {
        final var location = element.getLocation();
        final var size = element.getSize();
        final var x = (size.getWidth() / 2) + location.getX();
        final var y = (size.getHeight() / 2) + location.getY();
        return getCorrectedCoordinates(element, new Point(x, y));
    }

    private Point getCorrectedCoordinates(final WebElement element, final Point point) {
        final var screenSize = getScreenSize();
        var x = point.getX();
        var y = point.getY();
        int w;
        int h;
        if (Objects.nonNull(element)) {
            final var size = element.getSize();
            final var location = element.getLocation();
            w = size.getWidth() + location.getX();
            h = size.getHeight() + location.getY();
        } else {
            w = screenSize.getWidth();
            h = screenSize.getHeight();
        }

        if (x >= w) {
            x = w - 5;
        }
        if (y >= h) {
            y = h - 5;
        }
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 5;
        }
        return new Point(x, y);
    }

    private Dimension getScreenSize() {
        return this.driver.manage()
                .window()
                .getSize();
    }
}
