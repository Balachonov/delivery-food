package balachonov.util;

public final class Constants {

    /**
     * Constants for the UserRepository
     */
    public static final String SQL_ID_USER = "id_user";
    public static final String SQL_FIRST_NAME = "first_name";
    public static final String SQL_LAST_NAME = "last_name";
    public static final String SQL_EMAIL = "email";
    public static final String SQL_ADDRESS = "address";
    public static final String SQL_PASSWORD = "password";
    public static final String SQL_SALT = "salt";
    public static final String SQL_USER_ROLE = "user_role";
    public static final String SQL_DELETE_USER = "DELETE FROM users WHERE id_user = ?";
    public static final String SQL_UPDATE_USER = "UPDATE users SET first_name = ?, last_name = ?, email = ?, " +
            "address = ?, password = ?, salt = ?, user_role = ?  WHERE id_user = ?";
    public static final String SQL_GET_USER_BY_ID = "SELECT * FROM users WHERE id_user = ?";
    public static final String SQL_GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
    public static final String SQL_GET_ALL_USER = "SELECT * FROM users";
    public static final String SQL_ADMIN_CREATE_USER = "INSERT INTO users (first_name, last_name, email, address, " +
            "password, salt, user_role) VALUES (?,?,?,?,?,?,?)";
    public static final String SQL_SIMPLE_CREATE_USER = "INSERT INTO users (first_name, last_name, email, address, " +
            "password, salt) VALUES (?,?,?,?,?,?)";


    /**
     * Constants for the FoodRepository
     */
    public static final String SQL_ID_FOOD = "id_food";
    public static final String SQL_NAME = "name";
    public static final String SQL_PRICE = "price";
    public static final String SQL_WEIGHT = "weight";
    public static final String SQL_DESCRIPTION = "description";
    public static final String SQL_COMPOSITION = "composition";
    public static final String SQL_FOOD_TYPE = "food_type";
    public static final String SQL_CREATE_FOOD = "INSERT INTO foods (name, price, weight, description, " +
            "composition, food_type) VALUES (?,?,?,?,?,?)";
    public static final String SQL_GET_FOOD_BY_ID = "SELECT * FROM foods WHERE id_food = ?";
    public static final String SQL_GET_FOOD_BY_NAME = "SELECT * FROM foods WHERE name = ?";
    public static final String SQL_UPDATE_FOOD = "UPDATE foods SET name = ?, price = ?, weight = ?, " +
            "description = ?, composition = ?, food_type = ?  WHERE id_food = ?";
    public static final String SQL_GET_ALL_FOOD = "SELECT * FROM foods";
    public static final String SQL_DELETE_FOOD = "DELETE FROM foods WHERE id_food = ?";
    /**
     * Constants for the PasswordGenerationAndCheckImpl
     */
    public static final String ALGORITHM_PASS = "PBKDF2WithHmacSHA1";
    public static final String ALGORITHM_SALT = "SHA1PRNG";
    public static final String CODE = "UTF_16";
    public static final String DEFAULT = "default";

    /**
     * Constants for the ConnectionManager
     */
    public static final String URL_KEY = "db.url";
    public static final String USERNAME_KEY = "db.username";
    public static final String PASSWORD_KEY = "db.password";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String ERR = "Ошибка загрузки драйвера";

    /**
     * Constants for the Properties of the ConnectionManager
     */
    public static final String APP_PROP = "application.properties";

    private Constants() {
    }
}
