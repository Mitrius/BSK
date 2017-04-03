package com.bsk.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Mitrius on 03.04.17.
 */
public class AbstractDao<PK extends Serializable, T> {
    private final Class<T> persistentClass;

    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        Session temp = sessionFactory.getCurrentSession();
        return temp;
    }

    public T getByKey(PK key) {
        return (T) getCurrentSession().get(persistentClass, key);
    }

    public void persist(T entity) {
        getCurrentSession().persist(entity);
    }

    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    protected Criteria createEntityCriteria() {
        return getCurrentSession().createCriteria(persistentClass);
    }
}
