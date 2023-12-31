package pl.hetman.wiktoria.solvd.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static BlockingQueue<ConnectionManager> pool;
    private static int poolSize = 5;

    private ConnectionPool() {
        LOGGER.info("ConnectionPool()");
        LOGGER.info("ConnectionPool(...)");
    }

    public static synchronized BlockingQueue<ConnectionManager> getInstance() throws ToyShopException {
        LOGGER.info("getInstance()");
        if (pool == null) {
            pool = new ArrayBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                pool.add(ConnectionManager.getInstance());
            }
        }
        LOGGER.info("getInstance(...)");
        return pool;
    }
}
