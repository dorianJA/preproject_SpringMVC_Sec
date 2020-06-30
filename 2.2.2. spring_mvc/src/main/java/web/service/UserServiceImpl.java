package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDAOImpl")
    private UserDAO userDAO;

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
    @Transactional
    @Override
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }
    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    @Transactional
    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }
}
