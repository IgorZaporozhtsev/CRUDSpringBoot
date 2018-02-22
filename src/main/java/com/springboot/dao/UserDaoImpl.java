package com.springboot.dao;

import com.springboot.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate; //Spring Hibernate template

    @Autowired
    private SessionFactory sessionFactory; //Spring Hibernate template

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUser() {
        hibernateTemplate.setCheckWriteOperations(false);
        String hql = "FROM User";
        return (List<User>) hibernateTemplate.find(hql);
    }

    @Override
    public void addUser(User user){
        hibernateTemplate.setCheckWriteOperations(false);
        hibernateTemplate.save(user);
    }

    @Override
    public void updateUser (User user) {
        User u = getUserById(user.getId());
        u.setName(user.getName());
        u.setPassword(user.getPassword());
        u.setLogin(user.getLogin());
        hibernateTemplate.update(u);
    }

    @Override
    public User getUserById(int id){
        return hibernateTemplate.get(User.class, id);
    }

    @Override
    public User getUserByLogin(String login){
        return (User) sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.login = :login")
                .setParameter("login", login).uniqueResult();
    }

    @Override
    public void deleteUser(int id){
        hibernateTemplate.delete(getUserById(id));
    }



}
