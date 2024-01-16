package pl.hetman.wiktoria.solvd.service.impl;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Discount;
import pl.hetman.wiktoria.solvd.persistence.impl.DiscountRepositoryImpl;
import pl.hetman.wiktoria.solvd.service.DiscountService;

import java.util.Optional;

public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepositoryImpl discountRepository;

    public DiscountServiceImpl(DiscountRepositoryImpl discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public Optional<Discount> findById(Long id) throws ToyShopException {
        if (id == null) {
            throw new ToyShopException("Can't find a toy. Id is null");
        } else {
            Optional<Discount> foundDiscount = discountRepository.findById(id);
            return foundDiscount;
        }
    }
}
