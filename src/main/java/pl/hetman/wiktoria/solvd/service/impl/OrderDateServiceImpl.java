package pl.hetman.wiktoria.solvd.service.impl;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.OrderDate;
import pl.hetman.wiktoria.solvd.persistence.OrderDateRepository;
import pl.hetman.wiktoria.solvd.service.OrderDateService;

import java.util.Optional;

public class OrderDateServiceImpl implements OrderDateService {

    private final OrderDateRepository orderDateRepository;

    public OrderDateServiceImpl(OrderDateRepository orderDateRepository) {
        this.orderDateRepository = orderDateRepository;
    }

    @Override
    public Optional<OrderDate> findById(Long id) throws ToyShopException {
        if (id == null) {
            throw new ToyShopException("Can't find OrderDate, id is null ");
        } else {
            OrderDate foundOrderDate = orderDateRepository.findById(id).orElseThrow(
                    () -> new ToyShopException("Can't find OrderDate.")
            );
            return Optional.of(foundOrderDate);
        }
    }
}
