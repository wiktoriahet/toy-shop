package pl.hetman.wiktoria.solvd.persistence;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class PersistenceConfig {

    private static final String myBatisConfig = "mybatisconfig.xml";
    private static final SqlSessionFactory sessionFactory;

    static {
        try (InputStream inputStream = Resources.getResourceAsStream(myBatisConfig);) {

            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
