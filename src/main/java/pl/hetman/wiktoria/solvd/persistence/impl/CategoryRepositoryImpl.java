package pl.hetman.wiktoria.solvd.persistence.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.model.Category;
import pl.hetman.wiktoria.solvd.persistence.Repository;

import java.util.Optional;

public class CategoryRepositoryImpl implements Repository<Category> {

    private static final Logger LOGGER = LogManager.getLogger(CategoryRepositoryImpl.class);

    @Override
    public Optional<Category> create(Category category) {
        LOGGER.info("create(" + category + ")");
        /**
         * Creates a category
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("create(...)");
        return Optional.empty();
    }

    @Override
    public Optional<Category> findById(Long id) {
        LOGGER.info("findById(" + id + ")");
        /**
         * Finds category by id
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("findById(...)");
        return Optional.empty();
    }

    @Override
    public void updateById(Long id, Category category) {
        LOGGER.info("updateById(" + id + ", " + category + ")");
        /**
         * Update category
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("updateById(...)");
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.info("deleteById(" + id + ")");
        /**
         * Delete a category by id
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("deleteById(...)");
    }
}
