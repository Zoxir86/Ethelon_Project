package com.dao;

import com.database.Interest;
import com.dto.InterestDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class InterestDAOImplementation implements InterestDAO {

    private static final boolean SUCCESS = true;
    private static final boolean ERROR = false;

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";

    /********************************************************************************************************************
     Returns the full list of Interests. Returns null if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<InterestDTO> getFullListOfInterests()
    {
        initializeInterestTable();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<InterestDTO> interestDTOList = new ArrayList<InterestDTO>();

        try {
            Query q = em.createQuery("SELECT i FROM Interest i ");
            List<Interest> interestsList = q.getResultList();
            InterestDTO temp;

            if (interestsList.size() != 0) {
                for (Interest current : interestsList) {
                    temp = transformInterestEntity2DTO(current);
                    temp.setDatabaseID(current.getInterestID());
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
     Utility: Checks if the Interest table is currently empty.
     *******************************************************************************************************************/

    private boolean checkIfInterestTableIsEmpty() {
        EntityManagerFactory factory;
        EntityManager em;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        Query q = em.createQuery ("SELECT count(x) FROM Interest x");
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
     Utility: If the Interest table is currently empty, it populates it with fixed values.
     *******************************************************************************************************************/

    private boolean initializeInterestTable() {

        if(!checkIfInterestTableIsEmpty()) return SUCCESS;

        EntityManagerFactory factory;
        EntityManager em;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        ArrayList<Interest> list = Utilities.getListOfAllInterests();
        boolean result;

        try {
            em.getTransaction().begin();

            for (Interest interest : list) {
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

    public static InterestDTO transformInterestEntity2DTO(Interest entity)
    {
        InterestDTO dto = new InterestDTO();
        dto.setDatabaseID(entity.getInterestID());
        dto.setDescriptionGreekUpperCase(entity.getDescriptionGreekUpperCase());
        dto.setDescriptionEnglishUpperCase(entity.getDescriptionEnglishUpperCase());
        dto.setDescriptionGreekLowerCase(entity.getDescriptionGreekLowerCase());
        dto.setDescriptionEnglishLowerCase(entity.getDescriptionEnglishLowerCase());
        return  dto;
    }


    /******************************************************************************************************************
     Utility: Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).
     *****************************************************************************************************************/

    public static Interest transformInterestDTO2Entity(InterestDTO dto)
    {
        Interest entity = new Interest();
        entity.setInterestId(dto.getDatabaseID());
        entity.setDescriptionGreekUpperCase(dto.getDescriptionGreekUpperCase());
        entity.setDescriptionEnglishUpperCase(dto.getDescriptionEnglishUpperCase());
        entity.setDescriptionGreekLowerCase(dto.getDescriptionGreekLowerCase());
        entity.setDescriptionEnglishLowerCase(dto.getDescriptionEnglishLowerCase());
        return  entity;
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
