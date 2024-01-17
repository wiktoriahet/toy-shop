package pl.hetman.wiktoria.solvd.service.proxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.WebException;

class ProxyWebConnectionTest {

    @Test
    void validateConnect() throws WebException {
        //given
        Connection connection = new ProxyWebConnection();

        //when
        boolean connectNewHost = connection.connect("toyshoponline.com");

        //then
        Assertions.assertAll(
                () -> Assertions.assertThrows(
                        WebException.class,
                        () -> connection.connect("toysshop.com")
                ),
                () -> Assertions.assertEquals(true, connectNewHost)
        );

    }
}