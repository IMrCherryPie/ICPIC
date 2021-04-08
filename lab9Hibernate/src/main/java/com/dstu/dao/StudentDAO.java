package com.dstu.dao;

import com.dstu.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class StudentDAO extends DAOImpl<Student> {

    public List findJ() {
        Session session = getEntityManager().unwrap(Session.class);
        return  session.createQuery("SELECT  st.id AS st_id, st.name AS st_name, st.patronymic, st.surname, st.group.id AS st_group_id, st.course,  " +
                "pat.id AS pat_id, pat.name AS pat_name " +
                "FROM Student as st INNER JOIN FETCH Party AS pat ON " +
                "st.group = pat  WHERE  pat.name = 'MIN'").getResultList();
    }

}
