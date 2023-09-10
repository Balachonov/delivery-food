package balachonov.services;

public interface PasswordGenerationAndCheck {

    /**
     * Authentication and authorization password verification
     */
    boolean checkPassword(String inputPassword, String password);

    /**
     * Getting encrypted password
     */
    String getHashPassword(String password);
}