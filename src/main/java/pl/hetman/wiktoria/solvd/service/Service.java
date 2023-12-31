package pl.hetman.wiktoria.solvd.service;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Toy;

import java.util.Optional;

public interface Service<T> {

    Optional<T> create(T t) throws ToyShopException;

    Optional<T> findById(Long id) throws ToyShopException;

    void updateById(Long id, Toy toy) throws ToyShopException;

    void deleteById(Long id) throws ToyShopException;
}
