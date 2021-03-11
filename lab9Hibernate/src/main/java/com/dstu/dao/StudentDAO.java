package com.dstu.dao;

import com.dstu.bl.HibernateConnect;
import com.dstu.entity.Party;
import com.dstu.entity.Student;
import com.sun.istack.NotNull;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentDAO implements DAO<Student, Integer> {

    private final EntityManager entityManager = HibernateConnect.entityManager;
    private Session session = entityManager.unwrap(Session.class);


    /**
     *Create new student in students table.
     *
     * @param student for add.
     */
    public void create(@NotNull final Student student) {
            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();
    }
    /**
     * Get Student by model
     *
     * @param id for select
     * @return student with param model.
    */
    public Student findById(@NotNull final Integer id) {
            final Student result = session.get(Student.class, id);
            return result !=null ? result : new Student();

    }

    public List<Student> findAll(){
        session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Party ", Student.class).getResultList();
    }
    /**
     * Update student state.
     *
     * @param student new state.
     */
    public void update(Student student) {

            session.beginTransaction();

            session.update(student);

            session.getTransaction().commit();

    }
    /**
     * Save student state.
     *
     * @param student new state.
     */
    public void save(Student student) {

            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();

    }
    /**
     * Delete student.
     *
     * @param student for delete.
     */
    public void delete(Student student) {

            session.beginTransaction();

            session.delete(student);

            session.getTransaction().commit();


    }

}
