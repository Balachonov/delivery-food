package balachonov.repositories;

import balachonov.entities.User;
import balachonov.mappers.UserMapper;
import balachonov.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static balachonov.util.Constants.*;

public class UserRepositoryImpl implements UserRepository {

    private final UserMapper USER_MAPPER = new UserMapper();


    @Override
    public User adminCreate(User user) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SQL_ADMIN_CREATE_USER);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getSalt());
            statement.setString(7, user.getUserRole().getTitle());
            statement.execute();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User simpleCreate(User user) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SQL_SIMPLE_CREATE_USER);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getSalt());
            statement.execute();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<User> getUserById(String idUser) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USER_BY_ID);
            statement.setString(1, idUser);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = USER_MAPPER.buildUserForGetUserById(
                        resultSet.getString(SQL_ID_USER),
                        resultSet.getString(SQL_FIRST_NAME),
                        resultSet.getString(SQL_LAST_NAME),
                        resultSet.getString(SQL_EMAIL),
                        resultSet.getString(SQL_ADDRESS),
                        resultSet.getString(SQL_PASSWORD),
                        resultSet.getString(SQL_SALT),
                        resultSet.getString(SQL_USER_ROLE)
                );
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USER_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = USER_MAPPER.buildUserForGetUserById(
                        resultSet.getString(SQL_ID_USER),
                        resultSet.getString(SQL_FIRST_NAME),
                        resultSet.getString(SQL_LAST_NAME),
                        resultSet.getString(SQL_EMAIL),
                        resultSet.getString(SQL_ADDRESS),
                        resultSet.getString(SQL_PASSWORD),
                        resultSet.getString(SQL_SALT),
                        resultSet.getString(SQL_USER_ROLE)
                );
                return Optional.of(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> updateUser(String userId, User user) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USER_BY_ID);
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                PreparedStatement update = connection.prepareStatement(SQL_UPDATE_USER);
                update.setString(1, user.getFirstName());
                update.setString(2, user.getLastName());
                update.setString(3, user.getEmail());
                update.setString(4, user.getAddress());
                update.setString(5, user.getPassword());
                update.setString(6, user.getSalt());
                update.setString(7, user.getUserRole().getTitle());
                update.setString(8, userId);
                update.execute();
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_USER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = USER_MAPPER.buildUserForGetUserById(
                        resultSet.getString(SQL_ID_USER),
                        resultSet.getString(SQL_FIRST_NAME),
                        resultSet.getString(SQL_LAST_NAME),
                        resultSet.getString(SQL_EMAIL),
                        resultSet.getString(SQL_ADDRESS),
                        resultSet.getString(SQL_PASSWORD),
                        resultSet.getString(SQL_SALT),
                        resultSet.getString(SQL_USER_ROLE)
                );
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> deleteUser(String id) {
        Optional<User> optionalUser = getUserById(id);
        if (!optionalUser.isPresent()) {
            return Optional.empty();
        }
        User user = optionalUser.get();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER);
            statement.setString(1, id);
            statement.execute();
            return Optional.of(user);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
