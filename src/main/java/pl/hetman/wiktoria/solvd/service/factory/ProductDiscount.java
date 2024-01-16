package pl.hetman.wiktoria.solvd.service.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.OfferException;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Discount;
import pl.hetman.wiktoria.solvd.service.impl.DiscountServiceImpl;

import java.util.Optional;

public class ProductDiscount implements Offer {

    private static final Logger LOGGER = LogManager.getLogger(ProductDiscount.class);

    private final DiscountServiceImpl discountService;

    public ProductDiscount(DiscountServiceImpl discountService) {
        this.discountService = discountService;
    }

    @Override
    public Optional<Discount> makeOffer(Long id) throws OfferException, ToyShopException {
        LOGGER.info("makeOffer(" + id + ")");
        if (id == null) {
            throw new OfferException("Can't make an offer. Id is null.");
        }
        Optional<Discount> foundedDiscount = discountService.findById(id);
        LOGGER.info("makeOffer(...)");
        return foundedDiscount;
    }
}
