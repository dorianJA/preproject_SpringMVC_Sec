package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import web.model.Role;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
//        Session session = sessionFactory.openSession();
//        Query<User> query = session.createQuery("update User set name =:pName, age =:pAge," +
//                "password=:pPassword, roles=:pRoles where id =:pId");
//        query.setParameter("pName",user.getName());
//        query.setParameter("pAge",user.getAge());
//        query.setParameter("pPassword",user.getPassword());
//        query.setParameter("pRoles",user.getRoles());
//        query.setParameter("pId",user.getId());
//        query.executeUpdate();

    }

    @Override
    public void removeUser(Long id) {
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
    public User getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where id = :parId");
        query.setParameter("parId", id);
        Optional<User> user = Optional.ofNullable(query.getSingleResult());
        return user.get();
    }

    @Override
    public User getUserByName(String name) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User where name =:parName");
        query.setParameter("parName", name);
        User user = query.uniqueResult();
        return user;
    }
}
