package balachonov.util;

import balachonov.mappers.UserMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory
                    ("DeliveryFoodPersistence");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    public static void deleteEntityManager() {
        if (entityManager != null) {
            entityManager = null;
        }
    }

    private JPAUtil() {
    }
}
