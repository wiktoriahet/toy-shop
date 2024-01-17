package pl.hetman.wiktoria.solvd.service.proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.WebException;

import java.util.ArrayList;
import java.util.List;

public class ProxyWebConnection implements Connection {

    private static final Logger LOGGER = LogManager.getLogger(ProxyWebConnection.class);
    private static List<String> toyShopOldDomains;

    static {
        LOGGER.info("Entering ProxyWebConnection static block");
        toyShopOldDomains = new ArrayList<>();
        toyShopOldDomains.add("toysshop.com");
        toyShopOldDomains.add("toysshop.pl");
        toyShopOldDomains.add("toysshop.io");
        toyShopOldDomains.add("buytoysonline.com");
        LOGGER.info("Closing ProxyWebConnection static block");
    }

    private Connection connection = new WebConnection();

    @Override
    public boolean connect(String host) throws WebException {
        LOGGER.info("connect(" + host + ")");
        boolean flag = false;
        if (host == null) {
            LOGGER.warn("Can't connect with host. Host is null.");
            throw new WebException("Can't connect with host. Host is null.");
        } else {
            if (toyShopOldDomains.contains(host)) {
                System.out.println("Welcome to Toy Shop! This website is outdated: " + host);
                System.out.println("Please connect to our new website. ");
                LOGGER.warn("Access denided. Outdated host.");
                throw new WebException("Access denided. Outdated host.");
            }
            flag = true;
            connection.connect(host);
        }
        LOGGER.info("connect(...)");
        return flag;
    }
}
