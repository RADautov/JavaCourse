package ru.ivmiit.dao.impl;

import org.springframework.stereotype.Component;
import ru.ivmiit.dao.interfaces.UserDao;
import ru.ivmiit.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean userExistenceById(long id) {
        List<User> user = em.createQuery("from User u where u.id = :id")
                .setParameter("id", id)
                .getResultList();
        return user.size() > 0;
    }

    @Override
    public boolean userExistenceByLogin(String login) {
        List<User> user = em.createQuery("from User u where u.login = :login")
                .setParameter("login", login)
                .getResultList();
        return user.size() > 0;
    }

    @Override
    public User saveUser(User user) {
        em.persist(user);
        em.flush();
        return user;
    }

    @Override
    public User updateUser(User user) {
        User userFromDB = em.merge(user);
        return userFromDB;
    }

    @Override
    public void deleteUser(long id) {
        em.createQuery("delete from User u where u.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User getUserById(long id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = (User) em.createQuery("from User u where u.login = :login")
                .setParameter("login", login)
                .getSingleResult();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = em.createQuery("from User")
                .getResultList();
        return users;
    }
}
