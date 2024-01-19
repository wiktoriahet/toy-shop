package pl.hetman.wiktoria.solvd.service.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Order;
import pl.hetman.wiktoria.solvd.persistence.OrderDateRepository;
import pl.hetman.wiktoria.solvd.persistence.OrderPriceRepository;
import pl.hetman.wiktoria.solvd.persistence.impl.OrderDateRepositoryImpl;
import pl.hetman.wiktoria.solvd.persistence.impl.OrderPriceRepositoryImpl;
import pl.hetman.wiktoria.solvd.service.impl.OrderDateServiceImpl;
import pl.hetman.wiktoria.solvd.service.impl.OrderPriceServiceImpl;

class ContextTest {

    @Test
    void validateExecuteStrategyForCustomer() throws ToyShopException {
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

    @Test
    void validateExecuteStrategyForDate() throws ToyShopException {
        //given
        OrderDateRepository orderDateRepository = new OrderDateRepositoryImpl();
        OrderDateServiceImpl orderDateService = new OrderDateServiceImpl(orderDateRepository);
        Strategy strategy = new OrderComparisonByDate(orderDateService);
        Context context = new Context(strategy);

        Order firstOrder = new Order();
        firstOrder.setId(1L);

        Order secondOrder = new Order();
        secondOrder.setId(1L);

        //when
        boolean isDateTheSame = context.executeStrategy(firstOrder, secondOrder);


        //then
        Assertions.assertTrue(isDateTheSame, "Dates are not the same.");

    }

    @Test
    void validateExecuteStrategyForPrice() throws ToyShopException {
        //given
        OrderPriceRepository orderPriceRepository = new OrderPriceRepositoryImpl();
        OrderPriceServiceImpl orderPriceService = new OrderPriceServiceImpl(orderPriceRepository);
        Strategy strategy = new OrderComparisonByPrice(orderPriceService);
        Context context = new Context(strategy);

        Order firstOrder = new Order();
        firstOrder.setId(1L);

        Order secondOrder = new Order();
        secondOrder.setId(1L);

        //when
        boolean isPriceTheSame = context.executeStrategy(firstOrder, secondOrder);


        //then
        Assertions.assertTrue(isPriceTheSame, "Prices are not the same.");

    }
}