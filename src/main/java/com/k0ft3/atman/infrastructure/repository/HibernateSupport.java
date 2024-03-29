package com.k0ft3.atman.infrastructure.repository;

import org.hibernate.Session;

import javax.persistence.EntityManager;

abstract class HibernateSupport<T> {

    private EntityManager entityManager;

    HibernateSupport(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public void save(T object) {
        entityManager.persist(object);
        entityManager.flush();
    }
}