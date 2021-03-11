package com.dstu.dao;

import com.dstu.bl.HibernateConnect;
import com.dstu.entity.Party;
import com.dstu.entity.Teacher;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO implements DAO<Teacher, Integer> {

    private final EntityManager entityManager = HibernateConnect.entityManager;
    private Session session = null;

    /**
     *Create new Teacher in students table.
     *
     * @param teacher for add.
     */
    @Override
    public void create(Teacher teacher) {

            session.beginTransaction();

            session.save(teacher);

            session.getTransaction().commit();

    }
    /**
     * Get Teacher by model
     *
     * @param id for select
     * @return teacher with param model.
     */
    @Override
    public Teacher findById(Integer id) {
            final Teacher result = session.get(Teacher.class, id);
            if (result != null){
                Hibernate.initialize(result.getGroup());
            }
            return result !=null ? result : new Teacher();

    }

    public List<Teacher> findAll(){
        session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Party ", Teacher.class).getResultList();
    }

    /**
     * Update teacher state.
     *
     * @param teacher new state.
     */
    @Override
    public void update(Teacher teacher) {

        session = entityManager.unwrap(Session.class);

            session.beginTransaction();

            session.saveOrUpdate(teacher);

            session.getTransaction().commit();
    }
    /**
     * Save teacher state.
     *
     * @param teacher new state.
     */
    public void save(Teacher teacher) {

        session = entityManager.unwrap(Session.class);

            session.beginTransaction();

            session.save(teacher);

            session.getTransaction().commit();
    }
    /**
     * Delete teacher.
     *
     * @param teacher for delete.
     */
    @Override
    public void delete(Teacher teacher) {

            session.beginTransaction();

            session.delete(teacher);

            session.getTransaction().commit();
    }
}
