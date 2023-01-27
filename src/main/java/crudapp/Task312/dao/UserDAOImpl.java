package crudapp.Task312.dao;


import crudapp.Task312.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void updateUser(long id, @NotNull User newUserData) {
        User shouldBeUpdatedUser = entityManager.find(User.class, id);
        shouldBeUpdatedUser.setName(newUserData.getName());
        shouldBeUpdatedUser.setSex(newUserData.getSex());
        shouldBeUpdatedUser.setAge(newUserData.getAge());
    }
}
