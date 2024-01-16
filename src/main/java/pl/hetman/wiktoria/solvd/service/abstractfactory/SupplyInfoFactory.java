package pl.hetman.wiktoria.solvd.service.abstractfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.SupplyException;

public class SupplyInfoFactory extends AbstractFactory {

    private static final Logger LOGGER = LogManager.getLogger(SupplyInfoFactory.class);

    public static final String TOY_SUPPLY = "TOY SUPPLY";
    public static final String TOY_SUPPLIER = "TOY SUPPLIER";

    @Override
    SupplyInfo getSupplyInfo(String type) throws SupplyException{
        LOGGER.info("getContact(" + type + ")");
        switch (type) {
            case TOY_SUPPLY:
                LOGGER.info("getContact(...)");
                return new ToySupplyInfo();
            case TOY_SUPPLIER:
                LOGGER.info("getContact(...)");
                return new ToySupplierInfo();
            default:
                LOGGER.warn("Can't get information. Invalid type.");
                throw new SupplyException("Can't get information. Invalid type.");
        }
    }

    @Override
    Contact getContact(String type) {
        return null;
    }
}
