package pl.hetman.wiktoria.solvd.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredentialsProperties {
    private static final Logger LOGGER = LogManager.getLogger(CredentialsProperties.class);

    private Properties properties;

    public CredentialsProperties() {
        LOGGER.info("CredentialsProperties()");
        loadProperties();
        LOGGER.info("CredentialsProperties(...)");
    }

    private void loadProperties() {
        properties = new Properties();
        try (
                InputStream inputStream = Thread
                        .currentThread()
                        .getContextClassLoader()
                        .getResourceAsStream("credentials.properties")
        ) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                LOGGER.error("Could not find credentials.properties file");
            }
        } catch (IOException e) {
            LOGGER.error("Error loading properties", e);
        }
    }

    public String getProperty(String key) {
        LOGGER.info("getProperty(" + key + ")");
        String property = properties.getProperty(key);
        LOGGER.info("getProperty(" + key + ") = " + property + ")");
        return property;
    }

}
