package pl.hetman.wiktoria.solvd.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Discount;
import pl.hetman.wiktoria.solvd.persistence.impl.DiscountRepositoryImpl;
import pl.hetman.wiktoria.solvd.service.DiscountService;

import java.util.Optional;

public class DiscountServiceImpl implements DiscountService {

    private static final Logger LOGGER = LogManager.getLogger(DiscountServiceImpl.class);

    private final DiscountRepositoryImpl discountRepository;

    public DiscountServiceImpl(DiscountRepositoryImpl discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public Optional<Discount> findById(Long id) throws ToyShopException {
        LOGGER.info("findById(" + id + ")");
        if (id == null) {
            LOGGER.warn("Can't find a toy. Id is null");
            throw new ToyShopException("Can't find a toy. Id is null");
        } else {
            Optional<Discount> foundDiscount = discountRepository.findById(id);
            LOGGER.info("findById(...)");
            return foundDiscount;
        }
    }
}
