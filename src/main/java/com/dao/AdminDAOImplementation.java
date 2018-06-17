package com.dao;

import com.database.Volunteer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AdminDAOImplementation implements AdminDAO {

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";

    /**
     * Retrieve all the volunteers from the database.
     * @return List<Volunteers>
     */
    public List<Volunteer> getAllVolunteers() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Volunteer> listVolunteers = entityManager.createQuery( "SELECT a FROM Volunteer a").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
        return listVolunteers;
    }
}
