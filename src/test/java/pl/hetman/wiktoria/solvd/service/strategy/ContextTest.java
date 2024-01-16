package pl.hetman.wiktoria.solvd.service.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.model.Order;

class ContextTest {

    @Test
    void validateExecuteStrategyForCustomer() {
        //given
        Strategy strategy = new OrderComparisonByCustomer();
        Context context = new Context(strategy);

        Order firstOrder = new Order();
        firstOrder.setId(1L);
        firstOrder.setCustomerId(1L);

        Order secondOrder = new Order();
        secondOrder.setId(2L);
        secondOrder.setCustomerId(1L);


        //when
        boolean isCustomerTheSame = context.executeStrategy(firstOrder, secondOrder);

        //then
        Assertions.assertTrue(isCustomerTheSame, "customers are different");

    }
}