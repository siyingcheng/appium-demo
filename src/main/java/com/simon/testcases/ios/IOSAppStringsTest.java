package com.simon.testcases.ios;

import com.simon.core.test.AppIOSTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class IOSAppStringsTest extends AppIOSTest {

    @Test(groups = "WIP")
    public void getAppStrings() {
        Map<String, String> appStringMap = iosDriver.getAppStringMap();
        System.out.println(appStringMap);
        // May need app contains language profiles, like: en.lproj
        Assert.assertFalse(appStringMap.isEmpty());
    }

    @Test(groups = "WIP")
    public void getAppStringsUsingLang() {
        Map<String, String> appStringMap = iosDriver.getAppStringMap("en");
        System.out.println(appStringMap);
        // May need app contains language profiles, like: en.lproj
        Assert.assertFalse(appStringMap.isEmpty());
    }

    @Test(groups = "WIP")
    public void getAppStringsUsingLangAndFilesString() {
        Map<String, String> appStringMap = iosDriver.getAppStringMap("en", "Localizable.string");
        System.out.println(appStringMap);
        // May need app contains language profiles, like: en.lproj
        Assert.assertFalse(appStringMap.isEmpty());
    }
}
