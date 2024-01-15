package pl.hetman.wiktoria.solvd.persistence;

import org.apache.ibatis.annotations.Param;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Email;
import pl.hetman.wiktoria.solvd.model.Employee;
import pl.hetman.wiktoria.solvd.model.EmployeeContactEmail;

import java.util.Optional;

public interface EmployeeEmailRepository {

    Integer addEmail(@Param("employee") Employee employee, @Param("email") Email email);

    Optional<EmployeeContactEmail> findById(Long id) throws ToyShopException;

    void deleteById(Long id);
}
