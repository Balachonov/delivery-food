package balachonov.repositories;

import balachonov.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DishRepository extends JpaRepository<Dish, UUID> {

    Optional<Dish> findByName(String mail);
}