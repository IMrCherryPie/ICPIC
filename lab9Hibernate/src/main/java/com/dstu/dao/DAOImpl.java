package com.dstu.dao;

import com.dstu.bl.HibernateConnect;
import com.dstu.entity.Party;
import org.hibernate.Session;

import javax.persistence.EntityManager;

public abstract class DAOImpl<T> {

    private final EntityManager entityManager = HibernateConnect.entityManager;
    private Session session = null;

    protected DAOImpl() throws IllegalAccessException, InstantiationException {
    }

    /**
     *Create new obj in students table.
     *
     */
    public void create(Class<?> t) {

        session.beginTransaction();

        session.save(t);

        session.getTransaction().commit();

    }
    /**
     * Get Teacher by model
     *
     * @param id for select
     * @return teacher with param model.
     */
    public T findById(Class<?> dev, int id) throws IllegalAccessException, InstantiationException {
        final T result = (T) session.get(dev, id);
        return result !=null ? result : (T) dev.newInstance();

    }
    /**
     * Update teacher state.
     *
     */
    public void update(T t) {

        session = entityManager.unwrap(Session.class);

        session.beginTransaction();

        session.update(t);

        session.getTransaction().commit();
    }
    /**
     * Save teacher state.
     *
     */
    public void save(T t) {

        session = entityManager.unwrap(Session.class);

        session.beginTransaction();

        session.save(t);

        session.getTransaction().commit();
    }
    /**
     * Delete teacher.
     *
     */
    public void delete(T t) {

        session.beginTransaction();

        session.delete(t);

        session.getTransaction().commit();
    }

    public T findAll(Class<?> dev){
        session = entityManager.unwrap(Session.class);
        return (T) session.createQuery("FROM Party ", dev.getClass());
    }
}
