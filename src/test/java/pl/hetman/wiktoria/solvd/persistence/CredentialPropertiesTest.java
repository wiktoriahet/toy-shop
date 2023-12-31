package pl.hetman.wiktoria.solvd.persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CredentialPropertiesTest {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    @Test
    void getProperty() {
        //given
        CredentialsProperties credentialsProperties = new CredentialsProperties();

        //when
        String property = credentialsProperties.getProperty("database");
        String string = property.toString();
        System.out.println(string);

        //then
        Assertions.assertNotNull(property, "property is null");

    }
}
