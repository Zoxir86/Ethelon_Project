package com.dao;

import com.database.KnowledgeArea;
import com.dto.KnowledgeAreaDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class KnowledgeAreaDAOImplementation implements KnowledgeAreaDAO {

    private static final boolean SUCCESS = true;
    private static final boolean ERROR = false;

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";


    /********************************************************************************************************************
     Returns the full list of KnowledgeAreas. Returns null if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<KnowledgeAreaDTO> getFullListOfKnowledgeAreas()
    {
        initializeKnowledgeAreaTable();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<KnowledgeAreaDTO> interestDTOList = new ArrayList<KnowledgeAreaDTO>();

        try {
            Query q = em.createQuery("SELECT i FROM KnowledgeArea i ");
            List<KnowledgeArea> interestsList = q.getResultList();
            KnowledgeAreaDTO temp;

            if (interestsList.size() != 0) {
                for (KnowledgeArea current : interestsList) {
                    temp = transformKnowledgeAreaEntity2DTO(current);
                    temp.setDatabaseID(current.getKnowledgeAreaID());
                    interestDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            interestDTOList = null;
        } finally {
            em.close();
            factory.close();
        }

        return interestDTOList;
    }


    /********************************************************************************************************************
     Utility: Checks if the KnowledgeArea table is currently empty.
     *******************************************************************************************************************/

    private boolean checkIfKnowledgeAreaTableIsEmpty() {
        EntityManagerFactory factory;
        EntityManager em;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        Query q = em.createQuery ("SELECT count(x) FROM KnowledgeArea x");
        Number result = (Number) q.getSingleResult ();

        if(result.intValue() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /********************************************************************************************************************
     Utility: If the KnowledgeArea table is currently empty, it populates it with fixed values.
     *******************************************************************************************************************/

    private boolean initializeKnowledgeAreaTable() {

        if(!checkIfKnowledgeAreaTableIsEmpty()) return SUCCESS;

        EntityManagerFactory factory;
        EntityManager em;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        ArrayList<KnowledgeArea> list = Utilities.getListOfAllKnowledgeAreas();
        boolean result;

        try {
            em.getTransaction().begin();

            for (KnowledgeArea interest : list) {
                em.persist(interest);
            }

            em.getTransaction().commit();
            result = SUCCESS;
        } catch (Exception e) {
            em.getTransaction().rollback();
            result = ERROR;
        } finally {
            em.close();
            factory.close();
        }
        return result;
    }


    /******************************************************************************************************************
     Utility: Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static KnowledgeAreaDTO transformKnowledgeAreaEntity2DTO(KnowledgeArea entity)
    {
        KnowledgeAreaDTO dto = new KnowledgeAreaDTO();
        dto.setDatabaseID(entity.getKnowledgeAreaID());
        dto.setDescriptionGreekUpperCase(entity.getDescriptionGreekUpperCase());
        dto.setDescriptionEnglishUpperCase(entity.getDescriptionEnglishUpperCase());
        dto.setDescriptionGreekLowerCase(entity.getDescriptionGreekLowerCase());
        dto.setDescriptionEnglishLowerCase(entity.getDescriptionEnglishLowerCase());
        return  dto;
    }


    /******************************************************************************************************************
     Utility: Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).
     *****************************************************************************************************************/

    public static KnowledgeArea transformKnowledgeAreaDTO2Entity(KnowledgeAreaDTO dto)
    {
        KnowledgeArea entity = new KnowledgeArea();
        entity.setKnowledgeAreaID(dto.getDatabaseID());
        entity.setDescriptionGreekUpperCase(dto.getDescriptionGreekUpperCase());
        entity.setDescriptionEnglishUpperCase(dto.getDescriptionEnglishUpperCase());
        entity.setDescriptionGreekLowerCase(dto.getDescriptionGreekLowerCase());
        entity.setDescriptionEnglishLowerCase(dto.getDescriptionEnglishLowerCase());
        return  entity;
    }

    /******************************************************************************************************************
     Utility: Returns an KnowledgeArea entity as persisted in the database when the databaseID is known.
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

