package balachonov.services;

public interface PasswordGenerationAndCheck {

    boolean checkPassword(String inputPassword, String password);

    String getHashPassword(String password);

}
