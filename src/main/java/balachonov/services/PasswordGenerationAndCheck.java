package balachonov.services;

public interface PasswordGenerationAndCheck {

    /**
     * Check input password and database password
     */
    boolean checkPassword(String inputPassword, String password, String salt);

    /**
     * Generation hash input password
     */
    String getHashPassword(String password, String salt);

    /**
     * Generation salt
     */
    String generationSalt();
}
