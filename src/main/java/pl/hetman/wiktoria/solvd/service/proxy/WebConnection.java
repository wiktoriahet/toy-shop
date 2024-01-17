package pl.hetman.wiktoria.solvd.service.proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.WebException;

public class WebConnection implements Connection {

    private static final Logger LOGGER = LogManager.getLogger(WebConnection.class);

    @Override
    public boolean connect(String host) throws WebException {
        LOGGER.info("connect(" + host + ")");
        boolean flag = false;
        if (host == null) {
            LOGGER.warn("Can't connect with host. Host is null.");
            throw new WebException("Can't connect with host. Host is null.");
        } else {
            flag = true;
            System.out.println("Connecting with: " + host);
        }
        LOGGER.info("connect(...)");
        return flag;
    }
}
