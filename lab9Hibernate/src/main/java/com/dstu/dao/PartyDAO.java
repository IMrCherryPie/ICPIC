package com.dstu.dao;

import com.dstu.bl.HibernateConnect;
import com.dstu.entity.Party;
import com.sun.istack.NotNull;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class PartyDAO implements DAO<Party, Integer> {
    public PartyDAO() throws IllegalAccessException, InstantiationException {
    }

    private final EntityManager entityManager = HibernateConnect.entityManager;
    private Session session = entityManager.unwrap(Session.class);

    /**
     *Create new party in students table.
     *
     * @param party for add.
     */
    public void create(Party party) {
            session.beginTransaction();

            session.save(party);

            session.getTransaction().commit();
    }

   /**
     * Get Party by id
     *
     * @param id for select
     * @return party with param model.
     */
    public Party findById(@NotNull final Integer id) {
        final Party result = session.get(Party.class, id);
        return result !=null ? result : new Party();
    }

    public List<Party> findAll(){
        session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Party ", Party.class).getResultList();
    }

    /**
     * Update party state.
     *
     * @param party new state.
     */
    public void update(Party party) {

            session.beginTransaction();

            session.update(party);

            session.getTransaction().commit();
    }
    /**
     * Update party state.
     *
     * @param party new state.
     */
    public void save(Party party) {

            session.beginTransaction();

            session.save(party);

            session.getTransaction().commit();
    }
    /**
     * Delete party.
     *
     * @param party for delete.
     */
    public void delete(Party party) {

            session.beginTransaction();

            session.delete(party);

            session.getTransaction().commit();

    }
}
