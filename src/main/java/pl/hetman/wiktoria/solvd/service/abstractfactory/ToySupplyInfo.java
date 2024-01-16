package pl.hetman.wiktoria.solvd.service.abstractfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.model.ToySupply;

import java.util.Optional;

public class ToySupplyInfo implements SupplyInfo<ToySupply>{
    private static final Logger LOGGER = LogManager.getLogger(ToySupplyInfo.class);
    @Override
    public Optional<ToySupply> getSupplyInfo() {
        LOGGER.info("getSupplyInfo()");
        /**
         *
         * returns the quantity of toys in shop from db
         *
         * todo implement this method
         */
        LOGGER.info("getSupplyInfo(...)");
        return Optional.empty();
    }
}
