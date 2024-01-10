package pl.hetman.wiktoria.solvd.persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;

import java.sql.Connection;
import java.util.concurrent.BlockingQueue;

class ConnectionManagerTest {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    @Test
    void validateConnectionIsNotNull() throws ToyShopException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        Assertions.assertNotNull(connection, "Connection is null");
    }

    @Test
    void validateConnectionWithPool() throws ToyShopException, InterruptedException {
        //given
        BlockingQueue<ConnectionManager> instance = ConnectionPool.getInstance();

        //when
        Connection connection = instance.take().getConnection();

        //then
        Assertions.assertNotNull(connection, "Connection is null");

    }
}