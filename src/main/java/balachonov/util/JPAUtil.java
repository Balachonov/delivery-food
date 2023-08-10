package balachonov.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static balachonov.util.Constants.PERSISTENCE_UNIT_NAME;

public class JPAUtil {

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        return emf.createEntityManager();
    }

    private JPAUtil() {
    }
}
