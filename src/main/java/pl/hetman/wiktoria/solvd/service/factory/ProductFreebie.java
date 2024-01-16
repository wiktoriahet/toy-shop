package pl.hetman.wiktoria.solvd.service.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.OfferException;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Toy;
import pl.hetman.wiktoria.solvd.service.impl.ToyService;

import java.util.Optional;

public class ProductFreebie implements Offer {

    private static final Logger LOGGER = LogManager.getLogger(ProductFreebie.class);

    private final ToyService toyService;

    public ProductFreebie(ToyService toyService) {
        this.toyService = toyService;
    }

    @Override
    public Optional<Toy> makeOffer(Long id) throws ToyShopException, OfferException {
        LOGGER.info("makeOffer(" + id + ")");
        if (id == null) {
            LOGGER.warn("Can't make an offer. Id is null.");
            throw new OfferException("Can't make an offer. Id is null.");
        } else {
            Optional<Toy> foundedToy = toyService.findById(id);
            LOGGER.info("makeOffer(...)");
            return foundedToy;
        }
    }
}
