package pl.hetman.wiktoria.solvd.persistence;

import org.apache.ibatis.annotations.Param;
import pl.hetman.wiktoria.solvd.model.Email;
import pl.hetman.wiktoria.solvd.model.Toy;

import java.util.Optional;

public interface EmailRepository {

    Integer create(Email email);

    Optional<Toy> findById(Long id);

    void updateById(@Param("id") Long id, @Param("email") Email email);

    void deleteById(Long id);
}
