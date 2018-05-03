package ru.ivmiit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ivmiit.dao.interfaces.UserDao;
import ru.ivmiit.dto.AuthDto;
import ru.ivmiit.models.User;
import ru.ivmiit.services.interfaces.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User registration(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public User login(AuthDto authDto) {
        if (userDao.userExistenceByLogin(authDto.getLogin())) {

        }
        User user = userDao.getUserByLogin(authDto.getLogin());
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }
}
