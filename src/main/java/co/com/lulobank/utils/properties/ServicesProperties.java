package co.com.lulobank.utils.properties;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ServicesProperties {

    private static Properties prop = null;
    private ServicesProperties() {
        throw new IllegalStateException();
    }
    public static void loadProperties() throws IOException {
        if (prop == null) {
            prop = new Properties();
            File objclasspathRoot = new File(System.getProperty("user.dir"));
            String strFilePath = objclasspathRoot.getAbsolutePath();
            prop.load(new FileReader(strFilePath + "/services.properties"));
        }
    }
    public static String getJsonResponseDefaultPath() throws IOException {
        loadProperties();
        return prop.getProperty("JsonResponseDefaultPath");
    }

    public static String getProperties(String properties) throws IOException {
        loadProperties();
        return prop.getProperty(properties);
    }
}
