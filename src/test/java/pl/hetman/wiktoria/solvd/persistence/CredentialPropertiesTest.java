package pl.hetman.wiktoria.solvd.persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CredentialPropertiesTest {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    @Test
    void validateGetProperty() {
        //given
        CredentialsProperties credentialsProperties = new CredentialsProperties();

        //when
        String property = credentialsProperties.getProperty("database");

        //then
        Assertions.assertNotNull(property, "property is null");

    }
}
