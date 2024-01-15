package pl.hetman.wiktoria.solvd.persistence;

import org.apache.ibatis.annotations.Param;
import pl.hetman.wiktoria.solvd.model.Brand;
import pl.hetman.wiktoria.solvd.model.Toy;
import pl.hetman.wiktoria.solvd.model.ToyBrand;

import java.util.Optional;

public interface ToyBrandRepository {

    Integer create(@Param("id") Toy toy, @Param("id") Brand brand);

    Optional<ToyBrand> findById(Long id);

    void updateToyById(Long id, @Param("id") Toy toy);

    void updateBrandById(Long id, @Param("id") Brand brand);

    void deleteById(Long id);
}
