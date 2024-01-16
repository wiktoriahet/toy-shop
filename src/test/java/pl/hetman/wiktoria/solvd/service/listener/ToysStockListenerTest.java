package pl.hetman.wiktoria.solvd.service.listener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.model.ToySupply;

import static org.junit.jupiter.api.Assertions.*;

class ToysStockListenerTest {

    @Test
    void validateListener(){
        //given
        ToysStock toysStock = new ToysStock();
        ToySupply supply = new ToySupply();

        //when
        toysStock.addListener(supply);
        toysStock.setToysInStock(100);

        //then
        Assertions.assertEquals(supply.getQuantity(), 100);
    }

}