package com.bsk.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
public class AbstractDao<PK extends Serializable, T> {
    private final Class<T> persistentClass;
    @Autowired
    private SessionFactory sessionFactory;

    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public Session getCurrentSession() {
        Session temp = sessionFactory.getCurrentSession();
        return temp;
    }

    public T findByID(PK id) {
        return (T) getCurrentSession().get(persistentClass, id);
    }
    public List<T> findAll() {
        return (List<T>) createEntityCriteria().list();
    }

    public T getByKey(PK key) {

        return (T) getCurrentSession().get(persistentClass, key);
    }

    public Serializable convertToKeyType(String key) {
        return null;
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
