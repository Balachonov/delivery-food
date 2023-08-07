package balachonov.repositories;

import balachonov.dto.DishDto;
import balachonov.entities.Dish;
import balachonov.enums.DishType;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

import static balachonov.mappers.DishMapperDto.dishMapperDto;
import static balachonov.util.Constants.*;
import static balachonov.util.JPAUtil.getEntityManager;

public class DishRepositoryImpl implements DishRepository {
    @Override
    public List<Dish> readDishByType(DishType type) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Dish> dishCriteriaQuery = cb.createQuery(Dish.class);
        Root<Dish> dishRoot = dishCriteriaQuery.from(Dish.class);
        dishCriteriaQuery.select(dishRoot).where(cb.like(dishRoot.get(TYPE), String.valueOf(type)));
        em.close();
        return em.createQuery(dishCriteriaQuery).getResultList();
    }

    @Override
    public List<Dish> readArchiveDish() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Dish> dishCriteriaQuery = cb.createQuery(Dish.class);
        Root<Dish> dishRoot = dishCriteriaQuery.from(Dish.class);
        dishCriteriaQuery.select(dishRoot).where(cb.like(dishRoot.get(DELETED), ONE));
        em.close();
        return em.createQuery(dishCriteriaQuery).getResultList();
    }

    @Override
    public Optional<Dish> create(DishDto dishDto) {
        Dish dish = dishMapperDto.toEntity(dishDto);
        EntityManager em = getEntityManager();
        em.getTransaction();
        em.persist(dish);
        em.getTransaction().commit();
        em.close();
        return Optional.ofNullable(dish);
    }

    @Override
    public List<Dish> readAll() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Dish> dishCriteriaQuery = cb.createQuery(Dish.class);
        Root<Dish> dishRoot = dishCriteriaQuery.from(Dish.class);
        dishCriteriaQuery.select(dishRoot);
        List<Dish> dishes = em.createQuery(dishCriteriaQuery).getResultList();
        em.close();
        return dishes;
    }

    @Override
    public List<Dish> readAllWithRestriction(String name) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Dish> dishCriteriaQuery = cb.createQuery(Dish.class);
        Root<Dish> dishRoot = dishCriteriaQuery.from(Dish.class);
        dishCriteriaQuery.select(dishRoot).where(cb.like(dishRoot.get(NAME), name));
        em.close();
        return em.createQuery(dishCriteriaQuery).getResultList();
    }

    @Override
    public Optional<Dish> readById(String id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Dish dish = em.find(Dish.class, id);
        em.close();
        return Optional.ofNullable(dish);
    }

    @Override
    public Optional<Dish> update(DishDto dishDto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Dish dish = em.find(Dish.class, dishDto.getId());
        dishMapperDto.updateEntity(dishDto, dish);
        em.getTransaction().commit();
        em.close();
        return Optional.ofNullable(dish);
    }

    @Override
    public Optional<Dish> delete(DishDto dishDto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Dish dish = em.find(Dish.class, dishDto.getId());
        dish.setDeleted();
        em.getTransaction().commit();
        em.close();
        return Optional.ofNullable(dish);
    }
}
