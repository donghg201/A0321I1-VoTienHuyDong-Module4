package com.codegym.orm.repo;

import com.codegym.orm.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomerRepoImpl implements CustomerRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer findById(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Customer.class, id);
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        if (findById(customer.getId()) == null) {
            entityManager.persist(customer);
        } else {
            entityManager.merge(customer);
        }
        return true;
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        entityManager.refresh(findById(customer.getId()));
        return true;
    }
}
