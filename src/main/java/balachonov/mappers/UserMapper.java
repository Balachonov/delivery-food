package balachonov.mappers;

import balachonov.entities.User;
import balachonov.entities.UserRole;
import balachonov.services.PasswordGenerationAndCheck;
import balachonov.services.PasswordGenerationAndCheckImpl;

import static balachonov.entities.UserRole.*;

public class UserMapper {
    private static UserMapper userMapper;
    public static UserMapper getUserMapper() {
        if (userMapper == null){
            userMapper = new UserMapper();
        }
        return userMapper;
    }
    public User adminBuildUser(String firstName, String lastName, String email, String address,
                               String inputPassword, String userRole) {
        String salt = PasswordGenerationAndCheckImpl.getPasswordGenerationAndCheck().generationSalt();
        String password = PasswordGenerationAndCheckImpl.getPasswordGenerationAndCheck().
                getHashPassword(inputPassword, salt);
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

    public User buildUserWithId(String idUser, String firstName, String lastName, String email, String address,
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
        String salt = PasswordGenerationAndCheckImpl.getPasswordGenerationAndCheck().generationSalt();
        String password = PasswordGenerationAndCheckImpl.getPasswordGenerationAndCheck().
                getHashPassword(inputPassword, salt);
        String userRole = USER.getTitle();
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

    private UserRole getRole(String role) {
        if (role.equalsIgnoreCase(ADMIN.getTitle())) {
            return UserRole.ADMIN;
        } else if (role.equalsIgnoreCase(MANAGER.getTitle())) {
            return UserRole.MANAGER;
        } else if (role.equalsIgnoreCase(COURIER.getTitle())) {
            return UserRole.COURIER;
        } else return UserRole.USER;
    }

    private UserMapper(){}
}