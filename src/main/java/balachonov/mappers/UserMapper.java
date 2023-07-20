package balachonov.mappers;

import balachonov.entities.User;
import balachonov.entities.UserRole;
import balachonov.util.PasswordGenerationAndCheckImpl;

import static balachonov.entities.UserRole.USER;

public class UserMapper {
    private static UserMapper userMapper;

    public static UserMapper getUserMapper() {
        if (userMapper == null) {
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
                .userRole(UserRole.valueOf(userRole))
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
                .userRole(UserRole.valueOf(userRole))
                .build();
    }

    public User simpleBuildUser(String firstName, String lastName, String email, String address,
                                String inputPassword) {
        String salt = PasswordGenerationAndCheckImpl.getPasswordGenerationAndCheck().generationSalt();
        String password = PasswordGenerationAndCheckImpl.getPasswordGenerationAndCheck().
                getHashPassword(inputPassword, salt);
        String userRole = String.valueOf(USER);
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .address(address)
                .password(password)
                .salt(salt)
                .userRole(UserRole.valueOf(userRole))
                .build();
    }

    private UserMapper() {
    }
}