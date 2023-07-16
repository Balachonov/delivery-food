package balachonov.repositories;

import balachonov.entities.User;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User adminCreate(User user) {
        return null;
    }

    @Override
    public User simpleCreate(User user) {
        return null;
    }

    @Override
    public Optional<User> getUserById(String idUser) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> updateUser(String userId, User user) {
        return Optional.empty();
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public Optional<User> deleteUser(String id) {
        return Optional.empty();
    }
}
