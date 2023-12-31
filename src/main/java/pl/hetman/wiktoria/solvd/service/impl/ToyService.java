package pl.hetman.wiktoria.solvd.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Toy;
import pl.hetman.wiktoria.solvd.persistence.impl.ToyRepository;
import pl.hetman.wiktoria.solvd.service.Service;

import java.util.Optional;

public class ToyService implements Service<Toy> {
    private static final Logger LOGGER = LogManager.getLogger(ToyService.class);

    private final ToyRepository toyRepository;

    public ToyService(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    @Override
    public Optional<Toy> create(Toy toy) throws ToyShopException {
        LOGGER.info("create(" + toy + ")");
        if (toy == null) {
            LOGGER.warn("ToyShopException");
            throw new ToyShopException("Can't create a toy. Toy is null");
        } else {
            toyRepository.create(toy);
            LOGGER.info("Successfully created a toy.");
            LOGGER.info("create(...)");
            return Optional.of(toy);
        }
    }

    @Override
    public Optional<Toy> findById(Long id) throws ToyShopException {
        LOGGER.info("findById(" + id + ")");
        if (id == null) {
            LOGGER.warn("ToyShopException");
            throw new ToyShopException("Can't find a toy. Id is null");
        } else {
            Optional<Toy> foundToy = toyRepository.findById(id);
            LOGGER.info("Successfully found a toy.");
            LOGGER.info("findById(...)");
            return foundToy;
        }
    }

    @Override
    public void updateById(Long id, Toy toy) throws ToyShopException {
        LOGGER.info("updateById(" + id + ", " + toy + ")");
        if (id == null) {
            LOGGER.warn("ToyShopException");
            throw new ToyShopException("Can't update a toy. Id is null");
        } else if (toy == null) {
            LOGGER.warn("ToyShopException");
            throw new ToyShopException("Can't update a toy. Toy is null");
        } else {
            toyRepository.updateById(id, toy);
            LOGGER.info("Successfully updated a toy.");
            LOGGER.info("updateById(...)");
        }
    }

    @Override
    public void deleteById(Long id) throws ToyShopException {
        LOGGER.info("deleteById(" + id + ")");

        if (id == null) {
            LOGGER.warn("ToyShopException");
            throw new ToyShopException("Can't delete a toy. Id is null");
        } else {
            toyRepository.deleteById(id);
            LOGGER.info("Successfully deleted a toy.");
            LOGGER.info("deleteById(...)");
        }
    }
}
