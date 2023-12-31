package pl.hetman.wiktoria.solvd.persistence.impl;

import pl.hetman.wiktoria.solvd.model.Category;
import pl.hetman.wiktoria.solvd.persistence.Repository;

import java.util.Optional;

public class CategoryRepository implements Repository<Category> {
    @Override
    public Optional<Category> create(Category category) {
        return Optional.empty();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void updateById(Long id, Category category) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
