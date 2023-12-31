package pl.hetman.wiktoria.solvd.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionManager.class);

    private String driverClassName = "com.mysql.cj.jdbc.Driver";
    private String connectionUrl;
    private String dbUser;
    private String dbPwd;

    private static ConnectionManager connectionManager = null;

    private ConnectionManager() {
        CredentialsProperties credentialsProperties = new CredentialsProperties();
        try {
            Class.forName(driverClassName);
            connectionUrl = credentialsProperties.getProperty("database");
            dbUser = credentialsProperties.getProperty("dbuser");
            dbPwd = credentialsProperties.getProperty("dbpassword");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws ToyShopException {
        LOGGER.info("getConnection()");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        } catch (SQLException e) {
            LOGGER.error("Problem with connection");
            throw new ToyShopException("Problem with connection", e);
        }
        LOGGER.info("getConnection(...) = " + connection);
        return connection;
    }

    public static ConnectionManager getInstance() {
        LOGGER.info("getInstance()");
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();
        }
        LOGGER.info("getInstance(...)");
        return connectionManager;
    }

}
