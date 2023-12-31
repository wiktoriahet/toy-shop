package pl.hetman.wiktoria.solvd.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredentialsProperties {
    private static final Logger LOGGER = LogManager.getLogger(CredentialsProperties.class);

    public String getProperty(String key) {
        LOGGER.info("getProperty("+ key +")");
        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("credentials.properties");

        try {
            properties.load(inputStream);
            String property = properties.getProperty(key);
            LOGGER.info("getProperty(...)");
            return property;
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("getProperty(...)");
        return null;
    }

}
