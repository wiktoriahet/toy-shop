package pl.hetman.wiktoria.solvd.service.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.model.ToySupply;

import java.util.ArrayList;
import java.util.List;

public class ToysStock {

    private static final Logger LOGGER = LogManager.getLogger(ToysStock.class);

    private Integer toysInStock;
    private List<ToySupply> toySupplies = new ArrayList<>();

    public void addListener(ToySupply toySupply) {
        LOGGER.info("addListener(" + toySupply + ")");
        LOGGER.info("addListener(...)");
        this.toySupplies.add(toySupply);
    }

    public void removeListener(ToySupply toySupply) {
        LOGGER.info("removeListener(" + toySupply + ")");
        LOGGER.info("removeListener(...)");
        this.toySupplies.remove(toySupply);
    }

    public void setToysInStock(Integer toysInStock) {
        LOGGER.info("setToysInStock(" + toysInStock + ")");
        this.toysInStock = toysInStock;
        for (ToySupply toySupply : this.toySupplies) {
            toySupply.update(this.toysInStock);
        }
        LOGGER.info("removeListener(...)");
    }
}
