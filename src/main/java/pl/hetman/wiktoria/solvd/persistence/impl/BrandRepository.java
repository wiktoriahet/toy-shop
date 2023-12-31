package pl.hetman.wiktoria.solvd.persistence.impl;

import pl.hetman.wiktoria.solvd.model.Brand;
import pl.hetman.wiktoria.solvd.model.Toy;
import pl.hetman.wiktoria.solvd.persistence.Repository;

import java.util.Optional;

public class BrandRepository implements Repository<Brand> {
    @Override
    public Optional<Brand> create(Brand brand) {
        return Optional.empty();
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void updateById(Long id, Toy toy) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
