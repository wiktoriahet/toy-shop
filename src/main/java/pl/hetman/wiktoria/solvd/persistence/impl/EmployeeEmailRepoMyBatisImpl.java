package pl.hetman.wiktoria.solvd.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Email;
import pl.hetman.wiktoria.solvd.model.Employee;
import pl.hetman.wiktoria.solvd.model.EmployeeContactEmail;
import pl.hetman.wiktoria.solvd.persistence.EmployeeEmailRepository;
import pl.hetman.wiktoria.solvd.persistence.PersistenceConfig;

import java.util.Optional;

public class EmployeeEmailRepoMyBatisImpl implements EmployeeEmailRepository {

    private static final Logger LOGGER = LogManager.getLogger(EmployeeEmailRepoMyBatisImpl.class);

    @Override
    public Integer addEmail(Employee employee, Email email) {
        return null;
    }

    @Override
    public Optional<EmployeeContactEmail> findById(Long id) throws ToyShopException {

        if (id == null) {
            LOGGER.warn("Can't find EmployeeContactEmail. Id is null.");
            throw new ToyShopException("Can't find EmployeeContactEmail. Id is null.");
        } else {

            try (SqlSession sessionFactory =
                         PersistenceConfig
                                 .getSessionFactory()
                                 .openSession(true);) {


                EmployeeEmailRepository employeeEmailRepository =
                        sessionFactory.getMapper(EmployeeEmailRepository.class);

                EmployeeContactEmail employeeContactEmail = employeeEmailRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("Can't find EmployeeContact in db")
                );

                return Optional.of(employeeContactEmail);

            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            return Optional.empty();

        }
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.info("deleteById(" + id + ")");
        /**
         * Delete employee email by id
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("deleteById(...)");
    }
}
