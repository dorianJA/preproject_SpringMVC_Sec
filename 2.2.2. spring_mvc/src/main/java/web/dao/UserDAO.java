package web.dao;

import web.model.User;

import java.util.List;


public interface UserDAO  {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(Long id);
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String name);
}
