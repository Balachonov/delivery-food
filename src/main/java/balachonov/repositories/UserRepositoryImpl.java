package balachonov.repositories;

import balachonov.dto.UserDTO;
import balachonov.entities.User;
import balachonov.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

import static balachonov.mappers.UserMapperDto.INSTANCE_USER_DTO;
import static balachonov.util.Constants.*;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> create(UserDTO userDTO) {
        User user = INSTANCE_USER_DTO.toEntity(userDTO);
        EntityManager ENTITY_MANAGER = JPAUtil.getEntityManager();
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.persist(user);
        ENTITY_MANAGER.getTransaction().commit();
        ENTITY_MANAGER.close();
        JPAUtil.deleteEntityManager();
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> readAll() {
        EntityManager ENTITY_MANAGER = JPAUtil.getEntityManager();
        ENTITY_MANAGER.getTransaction().begin();
        List<User> users = ENTITY_MANAGER.createQuery
                        (JPQL_READ_ALL_USER , User.class)
                .getResultList();
        ENTITY_MANAGER.close();
        JPAUtil.deleteEntityManager();
        return users;
    }

    @Override
    public List<User> readAllWithRestriction(String role) {
        EntityManager ENTITY_MANAGER = JPAUtil.getEntityManager();
        ENTITY_MANAGER.getTransaction().begin();
        TypedQuery<User> query = ENTITY_MANAGER.createQuery
                (JPQL_READ_ALL_USER_WITH_RESTRICTION, User.class);
        List<User> users = query.setParameter(1, role).getResultList();
        ENTITY_MANAGER.close();
        JPAUtil.deleteEntityManager();
        return users;
    }

    @Override
    public Optional<User> read(String id) {
        EntityManager ENTITY_MANAGER = JPAUtil.getEntityManager();
        ENTITY_MANAGER.getTransaction().begin();
        User user = ENTITY_MANAGER.find(User.class, id);
        ENTITY_MANAGER.close();
        JPAUtil.deleteEntityManager();
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> readUserByEmail(String email) {
        EntityManager ENTITY_MANAGER = JPAUtil.getEntityManager();
        ENTITY_MANAGER.getTransaction().begin();
        TypedQuery<User> query = ENTITY_MANAGER.createQuery
                (JPQL_READ_USER_BY_EMAIL, User.class);
        User user = query.setParameter(1, email).getSingleResult();
        ENTITY_MANAGER.close();
        JPAUtil.deleteEntityManager();
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> readUserByAddress(String address) {
        EntityManager ENTITY_MANAGER = JPAUtil.getEntityManager();
        ENTITY_MANAGER.getTransaction().begin();
        TypedQuery<User> query = ENTITY_MANAGER.createQuery
                (JPQL_READ_USER_BY_ADDRESS, User.class);
        User user = query.setParameter(1, address).getSingleResult();
        ENTITY_MANAGER.close();
        JPAUtil.deleteEntityManager();
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> readArchiveUsers() {
        EntityManager ENTITY_MANAGER = JPAUtil.getEntityManager();
        ENTITY_MANAGER.getTransaction().begin();
        TypedQuery<User> query = ENTITY_MANAGER.createQuery
                (JPQL_READ_ARCHIVE_USER, User.class);
        List<User> users = query.setParameter(1, 1).getResultList();
        ENTITY_MANAGER.close();
        JPAUtil.deleteEntityManager();
        return users;
    }

    @Override
    public Optional<User> update(UserDTO userDTO) {
        EntityManager ENTITY_MANAGER = JPAUtil.getEntityManager();
        ENTITY_MANAGER.getTransaction().begin();
        User user = ENTITY_MANAGER.find(User.class, userDTO.getIdUser());
        INSTANCE_USER_DTO.updateEntity(userDTO, user);
        ENTITY_MANAGER.getTransaction().commit();
        ENTITY_MANAGER.close();
        JPAUtil.deleteEntityManager();
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> delete(UserDTO userDTO) {
        EntityManager ENTITY_MANAGER = JPAUtil.getEntityManager();
        ENTITY_MANAGER.getTransaction().begin();
        User user = ENTITY_MANAGER.find(User.class, userDTO.getIdUser());
        user.setDeleted();
        ENTITY_MANAGER.getTransaction().commit();
        ENTITY_MANAGER.close();
        JPAUtil.deleteEntityManager();
        return Optional.empty();
    }

    @Override
    public List<String> readUserOrders(UserDTO userDTO) {
        return null;
    }

}
