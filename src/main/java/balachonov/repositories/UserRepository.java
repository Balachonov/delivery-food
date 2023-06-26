package balachonov.repositories;

import balachonov.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    /**
     * Create a new user by admin
     */
    User adminCreate(User user);

    /**
     * Simple create a new user
     */
    User simpleCreate(User user);

    /**
     * Get a user by ID
     */
    Optional<User> getUserById(String idUser);

    /**
     * Get user by email
     */
    Optional<User> getUserByEmail(String email);

    /**
     * Update a user
     */
    Optional<User> updateUser(String userId, User user);

    /**
     * Get all users
     */
    List<User> getAllUser();

    /**
     * Delete a user
     */
    Optional<User> deleteUser(String id);
}
