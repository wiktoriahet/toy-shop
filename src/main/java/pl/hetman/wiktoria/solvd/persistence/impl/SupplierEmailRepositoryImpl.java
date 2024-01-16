package pl.hetman.wiktoria.solvd.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.SupplierContactEmail;
import pl.hetman.wiktoria.solvd.persistence.PersistenceConfig;
import pl.hetman.wiktoria.solvd.persistence.SupplierEmailRepository;

import java.util.Optional;

public class SupplierEmailRepositoryImpl implements SupplierEmailRepository {

    private static final Logger LOGGER = LogManager.getLogger(SupplierEmailRepositoryImpl.class);

    @Override
    public Optional<SupplierContactEmail> findById(Long id) throws ToyShopException {

        LOGGER.info("findById(" + id + ")");

        if (id == null) {
            throw new ToyShopException("Can't find EmployeeContactEmail. Id is null.");
        } else {

            try (SqlSession sessionFactory =
                         PersistenceConfig
                                 .getSessionFactory()
                                 .openSession(true);) {


                SupplierEmailRepository supplierEmailRepository = sessionFactory.getMapper(SupplierEmailRepository.class);

                SupplierContactEmail supplierContactEmail = supplierEmailRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("Can't find SupplierContact in db")
                );

                LOGGER.info("findById(...)");
                return Optional.of(supplierContactEmail);

            } catch (RuntimeException e) {
                LOGGER.warn(e.getMessage());
                e.printStackTrace();
            }
            return Optional.empty();

        }
    }
}
