package balachonov.repositories;

import balachonov.dto.DishDto;
import balachonov.entities.Dish;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

import static balachonov.mappers.mapstruct.DishMapperDto.dishMapperDto;
import static balachonov.util.Constants.*;
import static balachonov.util.JPAUtil.getEntityManager;
@Slf4j
public class DishRepositoryImpl implements DishRepository {
    @Override
    public List<Dish> readDishByType(String type) {
        log.info(LOG_READ_DISHES_BY_TYPE, type);
        return getDish(TYPE, type);
    }

    @Override
    public List<Dish> readArchiveDish() {
        log.info(LOG_READ_ARCHIVE_DISHES);
        return getDish(DELETED, ONE);
    }

    @Override
    public Optional<Dish> create(DishDto dishDto) {
        Dish dish = dishMapperDto.toEntity(dishDto);
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(dish);
        entityManager.getTransaction().commit();
        entityManager.close();
        log.info(LOG_DISH_CREATE, dish);
        return Optional.ofNullable(dish);
    }

    @Override
    public List<Dish> readAll() {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Dish> dishCriteriaQuery = criteriaBuilder.createQuery(Dish.class);
        Root<Dish> dishRoot = dishCriteriaQuery.from(Dish.class);
        dishCriteriaQuery.select(dishRoot);
        List<Dish> dishes = entityManager.createQuery(dishCriteriaQuery).getResultList();
        entityManager.close();
        log.info(LOG_READ_ALL_DISHES);
        return dishes;
    }

    @Override
    public List<Dish> readAllWithRestriction(String restriction) {
        log.info(LOG_READ_DISHES_BY_NAME, restriction);
        return getDish(NAME, restriction);
    }

    @Override
    public Optional<Dish> readById(String id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Dish dish = entityManager.find(Dish.class, id);
        entityManager.close();
        log.info(LOG_READ_DISHES_BY_ID, id);
        return Optional.ofNullable(dish);
    }

    @Override
    public Optional<Dish> update(DishDto dishDto) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Dish dish = entityManager.find(Dish.class, dishDto.getId());
        dishMapperDto.updateEntity(dishDto, dish);
        entityManager.getTransaction().commit();
        entityManager.close();
        log.info(LOG_DISH_UPDATE, dish);
        return Optional.ofNullable(dish);
    }

    @Override
    public Optional<Dish> delete(DishDto dishDto) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Dish dish = entityManager.find(Dish.class, dishDto.getId());
        dish.setDeleted();
        entityManager.getTransaction().commit();
        entityManager.close();
        log.info(LOG_DISH_ARCHIVED, dish);
        return Optional.ofNullable(dish);
    }

    private List<Dish> getDish(String field, String restriction) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Dish> dishCriteriaQuery = criteriaBuilder.createQuery(Dish.class);
        Root<Dish> dishRoot = dishCriteriaQuery.from(Dish.class);
        dishCriteriaQuery.select(dishRoot).where(criteriaBuilder.like(dishRoot.get(field), restriction));
        entityManager.close();
        return entityManager.createQuery(dishCriteriaQuery).getResultList();
    }
}
