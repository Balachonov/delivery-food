package balachonov.mappers;

import balachonov.entities.Basket;
import balachonov.entities.Dish;
import balachonov.entities.Person;

import java.time.LocalDateTime;
import java.util.List;

public class BasketMapper {
    private static BasketMapper basketMapper;

    public static BasketMapper getDishMapper() {
        if (basketMapper == null) {
            basketMapper = new BasketMapper();
        }
        return basketMapper;
    }

    public Basket buildBasket(Person owner, List<Dish> dishes,
                              String description, Integer closed) {
        return Basket.builder()
                .owner(owner)
                .dishes(dishes)
                .description(description)
                .orderTime(LocalDateTime.now())
                .closed(closed)
                .build();
    }

    public Basket buildBasketById(String id, Person owner, List<Dish> dishes,
                              String description,LocalDateTime orderTime, Integer closed) {
        return Basket.builder()
                .id(id)
                .owner(owner)
                .dishes(dishes)
                .description(description)
                .orderTime(orderTime)
                .closed(closed)
                .build();
    }

    private BasketMapper() {
    }
}
