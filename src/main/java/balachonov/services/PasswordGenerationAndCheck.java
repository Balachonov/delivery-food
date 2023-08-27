package balachonov.services;

public interface PasswordGenerationAndCheck {

    boolean checkPassword(String inputPassword, String password, String salt);

    String getHashPassword(String password, String salt);

    String generationSalt();
}
