package balachonov.repositories;

import balachonov.dto.DishDto;
import balachonov.entities.Dish;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

import static balachonov.mappers.mapstruct.DishMapperDto.dishMapperDto;
import static balachonov.util.Constants.*;
import static balachonov.util.JPAUtil.getEntityManager;

public class DishRepositoryImpl implements DishRepository {
    @Override
    public List<Dish> readDishByType(String type) {
        return getDish(TYPE, type);
    }

    @Override
    public List<Dish> readArchiveDish() {
        return getDish(DELETED, ONE);
    }

    @Override
    public Optional<Dish> create(DishDto dishDto) {
        Dish dish = dishMapperDto.toEntity(dishDto);
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
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
    public List<Dish> readAllWithRestriction(String restriction) {
        return getDish(NAME, restriction);
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

    private List<Dish> getDish(String field, String restriction) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Dish> dishCriteriaQuery = cb.createQuery(Dish.class);
        Root<Dish> dishRoot = dishCriteriaQuery.from(Dish.class);
        dishCriteriaQuery.select(dishRoot).where(cb.like(dishRoot.get(field), restriction));
        em.close();
        return em.createQuery(dishCriteriaQuery).getResultList();
    }
}
