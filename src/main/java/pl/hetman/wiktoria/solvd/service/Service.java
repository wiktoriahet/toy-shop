package pl.hetman.wiktoria.solvd.service;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;

import java.util.Optional;

public interface Service<T> {

    Optional<T> create(T t) throws ToyShopException;

    Optional<T> findById(Long id) throws ToyShopException;

    void updateById(Long id, T t) throws ToyShopException;

    void deleteById(Long id) throws ToyShopException;
}
