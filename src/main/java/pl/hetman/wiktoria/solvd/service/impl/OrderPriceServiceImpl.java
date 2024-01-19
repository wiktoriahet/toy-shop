package pl.hetman.wiktoria.solvd.service.impl;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.OrderPrice;
import pl.hetman.wiktoria.solvd.persistence.OrderPriceRepository;
import pl.hetman.wiktoria.solvd.service.OrderPriceService;

import java.util.Optional;

public class OrderPriceServiceImpl implements OrderPriceService {

    private final OrderPriceRepository orderPriceRepository;

    public OrderPriceServiceImpl(OrderPriceRepository orderPriceRepository) {
        this.orderPriceRepository = orderPriceRepository;
    }

    @Override
    public Optional<OrderPrice> findById(Long id) throws ToyShopException {
        if (id == null) {
            throw new ToyShopException("Can't find OrderDate, id is null ");
        } else {
            OrderPrice foundOrderPrice = orderPriceRepository.findById(id).orElseThrow(
                    () -> new ToyShopException("Can't find OrderDate.")
            );
            return Optional.of(foundOrderPrice);
        }
    }
}
