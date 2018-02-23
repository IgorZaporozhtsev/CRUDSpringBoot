package com.springboot.dao;

import com.springboot.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class RoleDaoImpl implements RoleDao {

   /* @Autowired
    private SessionFactory sessionFactory; //Spring Hibernate template*/

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleByRoleName(String roleName) {
            return (Role) entityManager.createQuery("FROM roles u WHERE u.name = :name")
                    .setParameter("name", roleName);
        }

    @Override
    public void addRole(Role roleName) {
        entityManager.persist(roleName);
    }
}
