package com.dao;

import com.database.SocialMedium;
import com.dto.SocialMediumDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocialMediumDAOImplementation implements SocialMediumDAO {

    private static final boolean SUCCESS = true;
    private static final boolean ERROR = false;

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";


    public SocialMediumDAOImplementation() {
        super();
    }


    /********************************************************************************************************************
     Inserts a new Social Medium entity in the database. Uses a DTO as input.
     Returns SUCCESS (true) or  ERROR (false).
     *******************************************************************************************************************/

    public boolean insertSocialMedium(SocialMediumDTO dto) {

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            SocialMedium entity = transformSocialMediumDTO2Entity(dto);
            entity.setInsertDate(Utilities.ft.format(new Date()));
            entity.setUpdateDate(Utilities.ft.format(new Date()));
            em.persist(entity);
            em.getTransaction().commit();
            result = SUCCESS;
        } catch(Exception e) {
            em.getTransaction().rollback();
            result = ERROR;
        }
        finally {
            if(em.isOpen()) em.close();
            factory.close();
        }
        return result;
    }


    /********************************************************************************************************************
     Deletes an existing Social Medium entity in the database. Uses a DTO as input.
     Returns SUCCESS (true) or  ERROR (false).
     *******************************************************************************************************************/

    public boolean deleteSocialMedium(SocialMediumDTO dto) {

        if(dto.getDatabaseID() == 0) return false;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            SocialMedium entity = em.find( SocialMedium.class, dto.getDatabaseID() );
            em.remove(entity);
            em.getTransaction().commit();
            result = SUCCESS;
        } catch(Exception e) {
            em.getTransaction().rollback();
            result = ERROR;
        }
        finally {
            em.close();
            factory.close();
        }
        return result;
    }


    /********************************************************************************************************************
     Updates an existing Social Medium entity in the database. Uses a DTO as input.
     Returns SUCCESS (true) or  ERROR (false).
     *******************************************************************************************************************/

    public boolean updateSocialMedium(SocialMediumDTO dto) {

        if(dto.getDatabaseID() == 0) return false;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            SocialMedium entity = em.find( SocialMedium.class, dto.getDatabaseID() );
            // Note that the databaseID is not being updated!.
            entity.setName(dto.getName());
            entity.setWebsite(dto.getWebsite());
            entity.setAccountPrefix(dto.getAccountPrefix());
            entity.setIcon(dto.getIcon());
            entity.setActiveYN(dto.isActiveYN());
            entity.setImportanceRank(dto.getImportanceRank());
            entity.setUpdateDate(Utilities.ft.format(new Date()));  // Note that the insertion date is not updated.
            em.persist(entity);
            em.getTransaction().commit();
            result = SUCCESS;
        } catch(Exception e) {
            em.getTransaction().rollback();
            result = ERROR;
        }
        finally {
            em.close();
            factory.close();
        }
        return result;
    }


    /********************************************************************************************************************
     Marks an existing Social Medium as inactive/active in the database. Uses a DTO as input.
     Returns SUCCESS (true) or  ERROR (false).
     *******************************************************************************************************************/

    public boolean changeSocialMediumActiveState(SocialMediumDTO dto) {

        if(dto.getDatabaseID() == 0) return false;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            SocialMedium entity = em.find( SocialMedium.class, dto.getDatabaseID() );
            entity.setActiveYN(!entity.isActiveYN());
            em.persist(entity);
            em.getTransaction().commit();
            result = SUCCESS;
        } catch(Exception e) {
            em.getTransaction().rollback();
            result = ERROR;
        }
        finally {
            em.close();
            factory.close();
        }
        return result;
    }


    /********************************************************************************************************************
     Returns a full list of Social Media. Sorted by importance rank. Returns empty list if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<SocialMediumDTO> getFullListOfSocialMedia()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<SocialMediumDTO> mediaDTOList = new ArrayList<SocialMediumDTO>();

        try {
            Query q = em.createQuery("SELECT m FROM SocialMedium m order by m.importanceRank ");
            List<SocialMedium> mediaList = q.getResultList();
            SocialMediumDTO temp;

            if (mediaList.size() != 0) {
                for (SocialMedium current : mediaList) {
                    temp = transformSocialMediumEntity2DTO(current);
                    temp.setDatabaseID(current.getSocialMediumID());
                    mediaDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            factory.close();
        }

        return mediaDTOList;
    }


    /********************************************************************************************************************
     Returns a full list of active Social Media. Sorted by importance rank. Returns empty list if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<SocialMediumDTO> getFullListOfActiveSocialMedia()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<SocialMediumDTO> mediaDTOList = new ArrayList<SocialMediumDTO>();

        try {
            Query q = em.createQuery("SELECT m FROM SocialMedium m WHERE m.isActiveYN = true order by m.importanceRank ");
            List<SocialMedium> mediaList = q.getResultList();
            SocialMediumDTO temp;

            if (mediaList.size() != 0) {
                for (SocialMedium current : mediaList) {
                    temp = transformSocialMediumEntity2DTO(current);
                    temp.setDatabaseID(current.getSocialMediumID());
                    mediaDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            factory.close();
        }

        return mediaDTOList;
    }


    /******************************************************************************************************************
     Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    private static SocialMediumDTO transformSocialMediumEntity2DTO(SocialMedium entity) {

        SocialMediumDTO dto = new SocialMediumDTO();
        dto.setDatabaseID(entity.getSocialMediumID());
        dto.setName(entity.getName());
        dto.setWebsite(entity.getWebsite());
        dto.setAccountPrefix(entity.getAccountPrefix());
        dto.setIcon(entity.getIcon());
        dto.setActiveYN(entity.isActiveYN());
        dto.setImportanceRank(entity.getImportanceRank());
        try {
            dto.setInsertDate(Utilities.ft.parse(entity.getInsertDate()));
            dto.setUpdateDate(Utilities.ft.parse(entity.getUpdateDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dto;
    }


    /******************************************************************************************************************
     Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).
     *****************************************************************************************************************/

    private static SocialMedium transformSocialMediumDTO2Entity(SocialMediumDTO dto) {

        SocialMedium entity = new SocialMedium();
        entity.setSocialMediumID(dto.getDatabaseID());
        entity.setName(dto.getName());
        entity.setWebsite(dto.getWebsite());
        entity.setAccountPrefix(dto.getAccountPrefix());
        entity.setIcon(dto.getIcon());
        entity.setActiveYN(dto.isActiveYN());
        entity.setImportanceRank(dto.getImportanceRank());
        // Note that insert and update dates do not travel towards the database using DTOs.
        return entity;
    }
}
