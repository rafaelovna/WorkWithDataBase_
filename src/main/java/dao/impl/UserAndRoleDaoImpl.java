package dao.impl;

import dao.UserAndRoleDao;
import hibernate.HibernateSessionFactoryUtil;
import model.Role;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserAndRoleDaoImpl implements UserAndRoleDao {
    @Override
    public void createUser(User user) {
        try (Session session = HibernateSessionFactoryUtil.getFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
    }

    @Override
    public void createRole(Role role) {
        try (Session session = HibernateSessionFactoryUtil.getFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(role);
            transaction.commit();
        }
    }

    @Override
    public List<User> readAll() {
        try (Session session = HibernateSessionFactoryUtil.getFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<User> user = session.createQuery("from User", User.class).list();
            System.out.println(user);
            transaction.commit();
            return user;
        }
    }

    @Override
    public User getByUser(int id) {
        try (Session session = HibernateSessionFactoryUtil.getFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            System.out.println(user+" "+ user.getRoles());
            transaction.commit();
            return user;
        }
    }

    @Override
    public Role getByRole(int id) {
        try (Session session = HibernateSessionFactoryUtil.getFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Role role = session.get(Role.class, id);
            System.out.println(role + " " + role.getUsers());
            transaction.commit();
            return role;
        }
    }

    @Override
    public void deleteUser(int id) {
        try (Session session = HibernateSessionFactoryUtil.getFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.remove(user);
            transaction.commit();
        }
    }

    @Override
    public void updateUser(User user) {
        try (Session session = HibernateSessionFactoryUtil.getFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
    }
}
