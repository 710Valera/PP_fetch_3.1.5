package ru.opolonina.kataPP.dao.imp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.opolonina.kataPP.dao.UserDao;
import ru.opolonina.kataPP.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {




    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
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
        if (user.getPassword() != null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void updateUser(User updateUser) {
        entityManager.merge(updateUser);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User findByUsername(String name) {
        String queryString = "Select u from User u left join fetch u.roles where u.username=:name";
        TypedQuery<User> query = entityManager.createQuery(queryString, User.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
