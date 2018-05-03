package ru.ivmiit.dao.interfaces;

import ru.ivmiit.models.User;

import java.util.List;

public interface UserDao {

    boolean userExistenceById(long id);

    boolean userExistenceByLogin(String login);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(long id);

    User getUserById(long id);

    User getUserByLogin(String login);

    List<User> getAllUsers();
}
