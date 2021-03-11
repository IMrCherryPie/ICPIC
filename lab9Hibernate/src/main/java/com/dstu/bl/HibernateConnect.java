package com.dstu.bl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class HibernateConnect {

    private static final String PERSISTENT_UNIT_NAME = "item-manager";
    public static EntityManager entityManager = getEntityManager();


    public HibernateConnect() {
    }

    private static EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME).createEntityManager();
    }

}
