package com.dao;

import com.database.KnowledgeArea;
import com.dto.KnowledgeAreaDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class KnowledgeAreaDAOImplementation {

    private static final boolean SUCCESS = true;
    private static final boolean ERROR = false;

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";

    public static KnowledgeAreaDTO transformKnowledgeAreaEntity2DTO(KnowledgeArea entity) {
        return null;
    }

    public static KnowledgeArea transformKnowledgeAreaDTO2Entity(KnowledgeAreaDTO dto) {
        return null;
    }

    /******************************************************************************************************************
     Utility: Returns an Interest entity as persisted in the database when the databaseID is known.
     *****************************************************************************************************************/

    public static KnowledgeArea findKnowledgeAreaById(int databaseID)
    {
        if(databaseID == 0) return null;

        KnowledgeArea entity;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            entity = em.find( KnowledgeArea.class, databaseID );
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
