package pl.hetman.wiktoria.solvd.service.abstractfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.model.Supply;

import java.util.Optional;

public class ToySupplierInfo implements SupplyInfo<Supply>{
    private static final Logger LOGGER = LogManager.getLogger(ToySupplierInfo.class);
    @Override
    public Optional<Supply> getSupplyInfo() {
        LOGGER.info("getSupplyInfo()");
        /**
         *
         * returns name of a supplier that supplies this toy
         *
         * todo implement this method
         */
        LOGGER.info("getSupplyInfo(...)");
        return Optional.empty();
    }
}
