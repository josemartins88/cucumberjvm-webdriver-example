package util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: jmartins
 * Date: 13/01/15
 */
public class PropertiesLoader {

    private static final String PROPERTIES_FILE = "/config/webdriver.properties";
    private static Logger LOG = Logger.getLogger(PropertiesLoader.class);

    public static Properties loadProperties() {
        InputStream in = PropertiesLoader.class.getResourceAsStream(PROPERTIES_FILE);
        Properties properties = new Properties();
        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            LOG.error("Couldn't load properties file: " + PROPERTIES_FILE, e);
        }
        return properties;
    }

}
