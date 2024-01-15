package pl.hetman.wiktoria.solvd.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Toy;
import pl.hetman.wiktoria.solvd.persistence.PersistenceConfig;
import pl.hetman.wiktoria.solvd.persistence.ToyRepository;

import java.util.Optional;

public class ToyRepositoryMyBatisImpl implements ToyRepository {
    @Override
    public Optional<Toy> create(Toy toy) throws ToyShopException {
        if (toy != null) {
            try (SqlSession sessionFactory =
                         PersistenceConfig
                                 .getSessionFactory()
                                 .openSession(true);) {
                ToyRepository toyRepository = sessionFactory.getMapper(ToyRepository.class);

                Toy createdToy = toyRepository.create(toy).orElseThrow(
                        () -> new ToyShopException("Can't create a toy")
                );
                return Optional.of(createdToy);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
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
