package balachonov.util;

public final class Constants {

    /**
     * General constants
     */
    public static final String DELETED = "deleted";
    public static final String DELETED_ZERO = "DELETED = 0";
    public static final String SPRING = "spring";

    /**
     * Constants for person
     */
    public static final String PERSONS = "persons";
    public static final String PERSON = "person";
    public static final String PERSON_ID = "PERSON_ID";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String TELEPHONE = "telephone";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String SALT = "salt";
    public static final String ROLE = "role";

    /**
     * Constants for basket
     */
    public static final String BASKETS = "baskets";
    public static final String BASKET_ID = "BASKET_ID";
    public static final String BASKET_DISH = "BASKET_DISH";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String ORDER_TIME = "ORDER_TIME";

    /**
     * Constants for dish
     */
    public static final String DISHES = "DISHES";
    public static final String DISH_ID = "DISH_ID";
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String TYPE = "type";

    /**
     * Constants for DTO mappers
     */
    public static final String ORDER_DISHES = "order.dishes";
    public static final String DISH_ORDERS = "dish.orders";
    public static final String PERSON_ORDERS = "person.orders";
    public static final String DISH_RESPONSES = "dishResponses";
    public static final String ORDER_RESPONSES = "orderResponses";

    /**
     * Constants for email sender
     */
    public static final String MESSAGE_ORDER = "Your order has been accepted and is being prepared." +
            " Thank you for choosing us";
    public static final String SUBJECT_ORDER = "Your order in the EL'Grillgo has been confirmed";
    public static final String SUBJECT_SUCCESSFUL_REGISTRATION = "Successful registration";
    public static final String MESSAGE_SUCCESSFUL_REGISTRATION = "Я тебя люблю";

    /**
     * Constants for service exception
     */
    public static final String PERSON_NOT_FOUND_BY_ID = "Person with id - %s is not found";
    public static final String PERSON_NOT_FOUND_BY_EMAIL = "Person with email - %s is not found";
    public static final String ORDER_NOT_FOUND_BY_ID = "Order with id - %s is not found";
    public static final String DISH_NOT_FOUND_BY_ID = "Dish with id - %s is not found";
    public static final String DISH_NOT_FOUND_BY_NAME = "Dish with name - %s is not found";
    public static final String LOG_ERR_EXCEPTION = "EXCEPTION: {}";
    public static final String ERR_VALID_MESSAGE = "Field: %s. Error: %s";
    public static final String ERR_PASSWORD_GENERATION_MESSAGE = "Oops. There are problems on the server. We are " +
            "already solving them.";

    /**
     * Constants for service HQL
     */
    public static final String PERSON_DELETE = "update Person person set person.deleted = 1 where person.id=:id";

    private Constants() {
    }
}