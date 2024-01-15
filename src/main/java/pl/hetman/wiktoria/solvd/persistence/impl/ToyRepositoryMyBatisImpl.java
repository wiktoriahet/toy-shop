package pl.hetman.wiktoria.solvd.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Toy;
import pl.hetman.wiktoria.solvd.persistence.PersistenceConfig;
import pl.hetman.wiktoria.solvd.persistence.ToyRepository;

import java.util.Optional;

public class ToyRepositoryMyBatisImpl implements ToyRepository {

    private static final Logger LOGGER = LogManager.getLogger(ToyRepositoryMyBatisImpl.class);

    @Override
    public Integer create(Toy toy) throws ToyShopException {
        LOGGER.info("create(" + toy + ")");
        if (toy == null) {
            LOGGER.warn("Can't create a toy. Toy is null");
            throw new ToyShopException("Can't create a toy. Toy is null");
        } else if (toy.getName() == null) {
            LOGGER.warn("Can't create a toy. toy.getName() is null");
            throw new ToyShopException("Can't create a toy. toy.getName() is null");
        } else {
            try (SqlSession sessionFactory =
                         PersistenceConfig
                                 .getSessionFactory()
                                 .openSession(true);) {
                ToyRepository toyRepository = sessionFactory.getMapper(ToyRepository.class);
                Integer createdToy = toyRepository.create(toy);
                LOGGER.info("create(...)");
                return createdToy;
//                Toy createdToy = toyRepository.create(toy).orElseThrow(
//                        () -> new ToyShopException("Can't create a toy")
//                );
//                return Optional.of(createdToy);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("create(...)");
        return null;
//        return Optional.empty();
    }

    @Override
    public Optional<Toy> findById(Long id) throws ToyShopException {
        if (id != null) {
            try (SqlSession sessionFactory =
                         PersistenceConfig
                                 .getSessionFactory()
                                 .openSession(true);) {
                ToyRepository toyRepository = sessionFactory.getMapper(ToyRepository.class);
                Toy foundToy = toyRepository.findById(id).orElseThrow(
                        () -> new ToyShopException("Can't find toy. Id is null.")
                );
                return Optional.of(foundToy);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    @Override
    public void updateById(Long id, Toy toy) throws ToyShopException {
        if (id == null) {
            throw new ToyShopException("Id is null");
        } else if (toy == null) {
            throw new ToyShopException("Toy is null");
        } else {
            try (SqlSession sessionFactory =
                         PersistenceConfig
                                 .getSessionFactory()
                                 .openSession(true);) {

                ToyRepository toyRepository = sessionFactory.getMapper(ToyRepository.class);
                toyRepository.updateById(id, toy);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteById(Long id) throws ToyShopException {
        if (id == null) {
            throw new ToyShopException("Id is null");
        } else {
            try (SqlSession sessionFactory =
                         PersistenceConfig
                                 .getSessionFactory()
                                 .openSession(true);) {
                ToyRepository toyRepository = sessionFactory.getMapper(ToyRepository.class);
                toyRepository.deleteById(id);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }
}
