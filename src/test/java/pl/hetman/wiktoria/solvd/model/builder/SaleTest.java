package pl.hetman.wiktoria.solvd.model.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;

class SaleTest {

    //given
    @Test
    void validateSaleBuilder() throws ToyShopException {
        Sale sale = new Sale.SaleBuilder()
                .setId(1L)
                .setOrderId(1L)
                .setEmployeeId(111L)
                .build();
        Assertions.assertNotNull(sale, "Sale is null");
    }
}