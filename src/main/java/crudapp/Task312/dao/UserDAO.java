package crudapp.Task312.dao;

import crudapp.Task312.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getUser(long id);
    public void saveUser(User user);
    public void deleteUser(long id);
    public void updateUser(long id, User newUserData);
}
