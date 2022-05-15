package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public void addUser(User user) {
            entityManager.persist(user);
        }

        @Override
        public void updateUser(User user) {
            entityManager.merge(user);
        }

        @Override
        public void removeUser(int id) {
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
        }

        @Override
        public User getUserById(int id) {
            return entityManager.find(User.class, id);
        }

        @Override
        public List<User> getListUsers() {
            return entityManager.createQuery("select u from User u", User.class).getResultList();
        }

        @Override
        public User getUserByName(String name) {
            return entityManager.createQuery("SELECT user FROM User user WHERE user.name =:name", User.class).setParameter("name", name).getSingleResult();
        }
}