package balachonov.mappers;

import balachonov.entities.User;
import balachonov.entities.UserRole;
import balachonov.services.PasswordGenerationAndCheck;
import balachonov.services.PasswordGenerationAndCheckImpl;

import static balachonov.entities.UserRole.*;
import static balachonov.entities.UserRole.USER;

public class UserMapper {
    private final PasswordGenerationAndCheck GENERATION_PASSWORD = new PasswordGenerationAndCheckImpl();

    public User adminBuildUser(String firstName, String lastName, String email, String address,
                               String inputPassword, String userRole) {
        String salt = GENERATION_PASSWORD.generationSalt();
        String password = GENERATION_PASSWORD.getHashPassword(inputPassword, salt);
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .address(address)
                .password(password)
                .salt(salt)
                .userRole(getRole(userRole))
                .build();
    }

    public User buildUserForGetUserById(String idUser, String firstName, String lastName, String email, String address,
                                        String password, String salt, String userRole) {

        return User.builder()
                .idUser(idUser)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .address(address)
                .password(password)
                .salt(salt)
                .userRole(getRole(userRole))
                .build();
    }

    public User simpleBuildUser(String firstName, String lastName, String email, String address,
                                String inputPassword) {
        String salt = GENERATION_PASSWORD.generationSalt();
        String password = GENERATION_PASSWORD.getHashPassword(inputPassword, salt);
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .address(address)
                .password(password)
                .salt(salt)
                .build();
    }

    private UserRole getRole(String role) {
        if (role.equals(ADMIN.getTitle())) {
            return UserRole.ADMIN;
        } else if (role.equals(MANAGER.getTitle())) {
            return MANAGER;
        } else if (role.equals(COURIER.getTitle())) {
            return COURIER;
        } else return USER;
    }
}