package balachonov.services;

import balachonov.entities.User;
import balachonov.repositories.UserRepository;
import balachonov.repositories.UserRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private final UserRepository USER_REPOSITORY = new UserRepositoryImpl();

    @Override
    public User adminCreate(User user) {
        return USER_REPOSITORY.adminCreate(user);
    }

    @Override
    public User simpleCreate(User user) {
        return USER_REPOSITORY.simpleCreate(user);
    }

    @Override
    public Optional<User> getUserById(String idUser) {
        return USER_REPOSITORY.getUserById(idUser);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return USER_REPOSITORY.getUserByEmail(email);
    }

    @Override
    public Optional<User> updateUser(String userId, User user) {
        return USER_REPOSITORY.updateUser(userId, user);
    }

    @Override
    public List<User> getAllUser() {
        return USER_REPOSITORY.getAllUser();
    }

    @Override
    public Optional<User> deleteUser(String id) {
        return USER_REPOSITORY.deleteUser(id);
    }
}
