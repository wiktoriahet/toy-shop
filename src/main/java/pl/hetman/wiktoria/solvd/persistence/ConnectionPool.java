package pl.hetman.wiktoria.solvd.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static volatile BlockingQueue<ConnectionManager> pool;
    private static int poolSize = 5;

    private ConnectionPool() {

    }

    public static synchronized BlockingQueue<ConnectionManager> getInstance() {
        LOGGER.info("getInstance()");
        if (pool == null) {
            synchronized (ConnectionPool.class) {
                if (pool == null) {
                    pool = new ArrayBlockingQueue<>(poolSize);
                    for (int i = 0; i < poolSize; i++) {
                        pool.add(ConnectionManager.getInstance());
                    }
                }
            }
        }
        LOGGER.info("getInstance(...)");
        return pool;
    }
}
