package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        session.delete(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        List<User> users = sessionFactory.getCurrentSession().createQuery("from User").list();
        return users;
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where id = :parId");
        query.setParameter("parId", id);
        User user = query.getSingleResult();
        return user;
    }
}
