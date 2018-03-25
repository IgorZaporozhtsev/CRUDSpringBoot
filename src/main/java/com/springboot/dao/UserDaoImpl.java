package com.springboot.dao;

import com.springboot.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

/*    @Autowired
    private HibernateTemplate hibernateTemplate; //Spring Hibernate template

    @Autowired
    private SessionFactory sessionFactory; //Spring Hibernate template*/

    @PersistenceContext
    private EntityManager entityManager;


    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUser() {
        String hql = "FROM User";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addUser(User user){
        entityManager.persist(user);
    }

    @Override
    public void updateUser (User user) {
        User u = getUserById(user.getId());
        u.setName(user.getName());
     //   u.setPassword(user.getPassword());
        u.setLogin(user.getLogin());
        entityManager.flush();
    }

    @Override
    public User getUserById(int id){
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByLogin(String login){
        return (User) entityManager.createQuery("FROM User u WHERE u.login = :login")
                .setParameter("login", login).getSingleResult();
    }

    @Override
    public void deleteUser(int id){
        entityManager.remove(getUserById(id));
    }



}
