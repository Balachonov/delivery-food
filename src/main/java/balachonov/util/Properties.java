package balachonov.util;

import java.io.IOException;
import java.io.InputStream;

import static balachonov.util.Constants.APP_PROP;

public final class Properties {
    private static final java.util.Properties PROPERTIES = new java.util.Properties();


    static {
        loadProperties();
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try (InputStream stream = Properties.class.getClassLoader().getResourceAsStream(APP_PROP)) {
            PROPERTIES.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Properties() {
    }
}
