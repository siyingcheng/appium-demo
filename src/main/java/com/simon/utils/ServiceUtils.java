package com.simon.utils;

import lombok.experimental.UtilityClass;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@UtilityClass
public class ServiceUtils {
    public static URL getUrl() {
        URL url;
        try {
            url = URI.create("http://127.0.0.1:4723/").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return url;
    }
}
