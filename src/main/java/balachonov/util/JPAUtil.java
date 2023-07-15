package balachonov.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    static final EntityManager ENTITY_MANAGER = createEntityManager();

    private static EntityManager createEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeliveryFoodPersistence");
        return emf.createEntityManager();
    }

    public static EntityManager getEntityManager(){
        return ENTITY_MANAGER;
    }
}
