package pl.hetman.wiktoria.solvd.persistence;

import org.apache.ibatis.annotations.Param;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Toy;

import java.util.Optional;

public interface ToyRepository {

    Optional<Toy> create(Toy toy) throws ToyShopException;

    Optional<Toy> findById(Long id) throws ToyShopException;

    void updateById(@Param("id") Long id, @Param("toy") Toy toy)throws ToyShopException;

    void deleteById(Long id)throws ToyShopException;
}
