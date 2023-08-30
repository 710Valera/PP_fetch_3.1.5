package ru.opolonina.kataPP.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.opolonina.kataPP.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {



    @PersistenceContext
    public EntityManager entityManager;


    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User findByUsername(String name) {
        String queryString = "Select u from User u left join fetch u.roles where u.firstName=:name";
        TypedQuery<User> query = entityManager.createQuery(queryString, User.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
