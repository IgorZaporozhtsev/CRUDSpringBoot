package com.springboot.dao;

import com.springboot.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Transactional
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory; //Spring Hibernate template

    @Override
    public Role getRoleByRoleName(String roleName) {
            return (Role) sessionFactory.getCurrentSession().createQuery("FROM roles u WHERE u.name = :name")
                    .setParameter("name", roleName).uniqueResult();
        }

    @Override
    public void addRole(Role roleName) {
        sessionFactory.getCurrentSession().persist(roleName);
    }
}
