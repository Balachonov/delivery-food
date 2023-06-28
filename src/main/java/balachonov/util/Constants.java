package balachonov.util;

public final class Constants {

    /**
     * Constants for user
     */
    public static final String USER = "user";
    public static final String ID_USER = "id_user";
    public static final String USER_FIRST_NAME = "first_name";
    public static final String USER_LAST_NAME = "last_name";
    public static final String USER_EMAIL = "email";
    public static final String USER_ADDRESS = "address";
    public static final String USER_PASSWORD = "password";
    public static final String USER_SALT = "salt";
    public static final String USER_ROLE = "user_role";

    /**
     * Constants for food
     */
    public static final String FOOD = "food";
    public static final String ID_FOOD = "id_food";
    public static final String FOOD_SQL_NAME = "name";
    public static final String FOOD_PRICE = "price";
    public static final String FOOD_WEIGHT = "weight";
    public static final String FOOD_DESCRIPTION = "description";
    public static final String FOOD_COMPOSITION = "composition";
    public static final String FOOD_TYPE = "food_type";

    /**
     * Constants for the UserRepository
     */
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

    /**
     * Pages name constants
     */
    public static final String PAGE_INDEX = "index.jsp";
    public static final String PAGE_SING_IN = "/pages/user/sing-in.jsp";
    public static final String PAGE_REGISTER = "/pages/user/register.jsp";
    public static final String PAGE_INVALID_USER = "/pages/message/invalid-user.jsp";
    public static final String PAGE_INVALID_USER_PASSWORD = "/pages/message/invalid-user-password.jsp";
    public static final String PAGE_INVALID_EMAIL_REGEX = "/pages/message/invalid-email-regex.jsp";
    public static final String PAGE_INVALID_PASSWORD_REGEX = "/pages/message/invalid-password-regex.jsp";
    public static final String PAGE_USER_OPENING_MENU = "/pages/user/user-opening-menu.jsp";
    public static final String PAGE_UPDATE_PERSONAL_DATA = "/pages/user/update-personal-data.jsp";
    public static final String PAGE_ALL_FOODS = "/pages/food/all-foods.jsp";
    public static final String PAGE_DELETE_YOUR_ACCOUNT = "/pages/user/delete-yourself.jsp";

    /**
     * JSP button name constants
     */
    public static final String BUTTON_SING_IN = "Sing In";
    public static final String BUTTON_REGISTER = "Register";
    public static final String BUTTON_UPDATE_PERSONAL_DATA = "Update your personal data";
    public static final String BUTTON_VIEW_ALL_PRODUCTS = "View all foods";
    public static final String BUTTON_DELETE_YOUR_ACCOUNT = "Delete your account";

    /**
     * Request parameter name constants
     */
    public static final String CHOICE_REQUEST = "choice";

    /**
     * Constants for the FoodRepository
     */
    public static final String REGEX_EMAIL = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z0-9]).{8, }$";

    private Constants() {
    }
}
