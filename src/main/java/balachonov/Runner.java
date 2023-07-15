package balachonov;

import balachonov.entities.User;
import balachonov.mappers.UserMapper;
import balachonov.util.JPAUtil;

import javax.persistence.EntityManager;

public class Runner {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();

        User user = UserMapper.getUserMapper().simpleBuildUser(
                "123",
                "123",
                "123",
                "123",
                "123"
        );

        entityManager.persist(user);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
