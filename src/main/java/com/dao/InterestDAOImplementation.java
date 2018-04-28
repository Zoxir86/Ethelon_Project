package com.dao;

import com.database.Interest;
import com.dto.InterestDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InterestDAOImplementation {

    private static final boolean SUCCESS = true;
    private static final boolean ERROR = false;

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";

    public static InterestDTO transformInterestEntity2DTO(Interest entity) {
        return null;
    }

    public static Interest transformInterestDTO2Entity(InterestDTO dto) {
        return null;
    }

    /******************************************************************************************************************
     Utility: Returns an Interest entity as persisted in the database when the databaseID is known.
     *****************************************************************************************************************/

    public static Interest findInterestById(int databaseID)
    {
        if(databaseID == 0) return null;

        Interest entity;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            entity = em.find( Interest.class, databaseID );
        } catch(Exception e) {
            entity = null;
        }
        finally {
            em.close();
            factory.close();
        }

        return entity;
    }
}
