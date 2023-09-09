package balachonov.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

    /**
     * Constants for person
     */
    public static final String PERSONS = "persons";
    public static final String PERSON = "person";
    public static final String PERSON_ID = "person_id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String TELEPHONE = "telephone";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String ROLE = "role";

    /**
     * Constants for basket
     */
    public static final String BASKETS = "baskets";
    public static final String BASKET_ID = "basket_id";
    public static final String BASKET_DISH = "basket_dish";
    public static final String DESCRIPTION = "description";
    public static final String ORDER_TIME = "order_time";
    public static final String OWNER = "owner";

    /**
     * Constants for dish
     */
    public static final String DISHES = "dishes";
    public static final String DISH_ID = "dish_id";
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
    public static final String MESSAGE_MAIL_ORDER = "Your order has been accepted and is being prepared." +
            " Thank you for choosing us";
    public static final String SUBJECT_MAIL_ORDER = "Your order in the EL'Grillgo has been confirmed";
    public static final String MESSAGE_MAIL_REGISTRATION = "Registration was successful. Thank you for choosing " +
            "our restaurant. We'll feed you.";
    public static final String SUBJECT_MAIL_REGISTRATION = "Successful registration";

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
    public static final String ERR_PAGE_NOT_FOUND = "Page not found";

    /**
     * Constants for ControllerLoggerAspect
     */
    public static final String REQUEST_LOGGER_PATTERN = """
            ==> Request: {}. URI: {}. Methods: {}.
            Request object: {}.""";
    public static final String RESPONSE_LOGGER_PATTERN = """
            <== Response: {}. URI: {}. Methods: {}.
            Response object: {}""";
    public static final String EXECUTION_TIME_LOGGER_PATTERN = "Methods: {}. Execution time: {} ms";
    public static final String MAIL_SEND_LOGGER_PATTERN = "Methods: {}. Send mail to: {}";

    /**
     * Constants for PhoneNumberConstraintValidator
     */
    public static final String CODE_BELARUS = "BY";
    public static final String ERR_MESSAGE_PHONE_NUMBER = "Enter a Belarusian phone number starting with +375";
}