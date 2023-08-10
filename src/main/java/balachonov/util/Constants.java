package balachonov.util;

public final class Constants {

    /**
     * General constants
     */
    public static final String ID = "id";
    public static final String DELETED = "deleted";
    public static final String DELETED_ZERO = "DELETED = 0";
    public static final String UUID = "uuid";
    public static final String UUID_STRATEGY = "org.hibernate.id.UUIDGenerator";
    public static final String PERSISTENCE_UNIT_NAME = "DeliveryFoodPersistence";

    /**
     * Constants for person
     */
    public static final String PERSONS = "persons";
    public static final String PERSON_ID = "PERSON_ID";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String SALT = "salt";
    public static final String ROLE = "role";
    public static final String ONE = "1";

    /**
     * Constants for address
     */
    public static final String ADDRESSES = "addresses";
    public static final String ADDRESS_ID = "ADDRESS_ID";
    public static final String CITY = "CITY";
    public static final String STREET = "STREET";
    public static final String HOUSE = "HOUSE";
    public static final String APARTMENT = "APARTMENT";
    public static final String PERSON_ADDRESS = "PERSON_ADDRESS";

    /**
     * Constants for basket
     */
    public static final String BASKETS = "baskets";
    public static final String BASKET = "BASKET";
    public static final String BASKET_ID = "BASKET_ID";
    public static final String BASKET_DISH = "BASKET_DISH";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String ORDER_TIME = "ORDER_TIME";
    public static final String CLOSED_ZERO = "CLOSED = 0";
    public static final String CLOSED = "CLOSED";


    /**
     * Constants for dish
     */
    public static final String DISHES = "DISHES";
    public static final String DISH_ID = "DISH_ID";
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String TYPE = "type";

    /**
     * Constants for the PasswordGenerationAndCheckImpl
     */
    public static final String ALGORITHM_PASS = "PBKDF2WithHmacSHA1";
    public static final String ALGORITHM_SALT = "SHA1PRNG";
    public static final String CODE = "UTF_16";
    public static final String DEFAULT = "default";

    /**
     * Constants for DTO mappers
     */
    public static final String ADDRESS_PERSONS ="address.persons";
    public static final String BASKET_DISHES = "basket.dishes";
    public static final String DISH_BASKETS = "dish.baskets";
    public static final String PERSON_ADDRESSES = "person.addresses";
    public static final String PERSON_BASKETS = "person.baskets";
    public static final String PERSONS_DTO = "personsDto";
    public static final String DISHES_DTO = "dishesDto";
    public static final String BASKETS_DTO = "basketsDto";
    public static final String ADDRESSES_DTO = "addressesDto";

    /**
     * Constants for email sender
     */
    public static final String COMPANY_GMAIL = "el.grilgo@gmail.com";
    public static final String PASSWORD_FOR_GMAIL = "mnxpltanqzxqwobd";
    public static final String HOST = "smtp.gmail.com";
    public static final String TRUE = "true";
    public static final String PORT = "587";
    public static final String MESSAGE_FOR_CLIENT = "Dear, %s. Your order has been accepted and is being prepared." +
            " Thank you for choosing us";
    public static final String SUBJECT_MAIL = "Your order in the EL'Grillgo has been confirmed";
    public static final String TRANSPORT_PROTOCOL = "smtp";

    /**
     * Constants for logger
     */
    public static final String LOG_PERSON_CREATE = "Person entity is create, object: {}";
    public static final String LOG_PERSON_UPDATE = "Person entity is update, object: {}";
    public static final String LOG_PERSON_ARCHIVED = "Person entity is archived, object: {}";
    public static final String LOG_READ_ALL_PERSONS = "Read all persons";
    public static final String LOG_READ_PERSONS_BY_ROLE = "Received persons by role: {}";
    public static final String LOG_READ_ARCHIVE_PERSONS = "Received archive persons";
    public static final String LOG_READ_PERSON_BY_ID = "Received person by id: {}";
    public static final String LOG_READ_PERSON_BY_EMAIL = "Received person by email: {}";
    public static final String LOG_READ_DISHES_BY_TYPE = "Received dishes by type: {}";
    public static final String LOG_READ_ARCHIVE_DISHES = "Received archive dishes";
    public static final String LOG_DISH_CREATE = "Dish entity is create, object: {}";
    public static final String LOG_READ_ALL_DISHES = "Read all dishes";
    public static final String LOG_READ_DISHES_BY_NAME = "Received dishes by name: {}";
    public static final String LOG_READ_DISHES_BY_ID = "Received dishes by id: {}";
    public static final String LOG_DISH_UPDATE = "Dish entity is update, object: {}";
    public static final String LOG_DISH_ARCHIVED = "Dish entity is archived, object: {}";
    public static final String LOG_PASS_CHECKED = "Password is checked";
    public static final String LOG_PASS_GENERATED = "Password is generated";
    public static final String LOG_ERR_PASS_GENERATED = "Password not generated";
    public static final String LOG_SALT_GENERATED = "Salt is generated";
    public static final String LOG_ERR_SALT_GENERATED = "Salt not generated";
    public static final String LOG_ERR_SEND_MESSAGE = "Message not send";
    public static final String LOG_SEND_MESSAGE = "Message is send, email: {}";

    /**
     * Regex constants
     */
    public static final String REGEX_EMAIL = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{8,20}$";

    private Constants() {
    }
}
