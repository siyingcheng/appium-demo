import com.simon.core.mobile.Direction;
import com.simon.core.utils.MobileGestures;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class PlayGround {
    public static void main(String[] args) throws MalformedURLException {
        MobileGestures.of(new IOSDriver(URI.create("").toURL(), null))
                .swipe(Direction.UP);
    }
}
