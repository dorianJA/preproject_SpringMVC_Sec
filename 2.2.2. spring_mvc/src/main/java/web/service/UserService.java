package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(User user);
    void updateUser(User user);
    void removeUser(Long id);
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String name);
}
