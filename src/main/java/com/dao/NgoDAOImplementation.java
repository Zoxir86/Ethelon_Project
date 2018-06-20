package com.dao;

import com.database.ApplicationState;
import com.database.Ngo;
import com.database.Opportunity;
import com.database.SocialMedium;
import com.dto.NgoDTO;
import com.dto.OpportunityDTO;
import com.dto.SocialMediumDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NgoDAOImplementation implements NgoDAO {

    private static final boolean SUCCESS = true;
    private static final boolean ERROR = false;

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";


    /********************************************************************************************************************
     Insert a new Ngo entity in the database. Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
     *******************************************************************************************************************/

    public boolean insertNgo(NgoDTO dto) {

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try{
            em.getTransaction().begin();
            Ngo entity = transformNgoDTO2Entity(dto);
            if(entity.getOpportunitiesList() == null) entity.setOpportunitiesList(new ArrayList<Opportunity>());
            if(entity.getSocialMediaList() == null) entity.setSocialMediaList(new ArrayList<SocialMedium>());
            entity.setAccountCreated(Utilities.ft.format(new Date()));
            entity.setAccountUpdated(Utilities.ft.format(new Date()));
            entity.setLastOpportunityUpload("");
            entity.setLoggedInLast(Utilities.ft.format(new Date()));
            entity.setStatus(ApplicationState.PENDING);
            entity.setHiddenYN(true);
            em.persist(entity);
            em.getTransaction().commit();
            result = SUCCESS;
        } catch (Exception e){
            em.getTransaction().rollback();
            result = ERROR;
        } finally {
            em.close();
            factory.close();
        }
        return result;
    }


    /********************************************************************************************************************
     Deletes an existing Ngo entity in the database. Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
     *******************************************************************************************************************/

    public boolean deleteNgo(NgoDTO dto){

        if(dto.getDatabaseID() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Ngo entity = em.find( Ngo.class, dto.getDatabaseID() );
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
     Updates an existing Ngo entity in the database. Uses a DTO as input.

     Note1: opportunitiesList, lastOpportunityUpload, loggedInLast, accountCreated, accountUpdated,
     username, password, userID are not updated through this method.
     Note2: Social Media entities are provided by the database, only the ID
     is used from the DTO.

     Returns SUCCESS (true) or ERROR (false).
     *******************************************************************************************************************/

    public boolean updateNgo(NgoDTO dto){

        if(dto.getDatabaseID() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try{
            em.getTransaction().begin();
            Ngo entity = em.find( Ngo.class, dto.getDatabaseID());

            entity.setOrganizationName(dto.getOrganizationName());
            entity.setWebpage(dto.getWebpage());
            entity.setAddress(dto.getAddress());
            entity.setStreetNo(dto.getStreetNo());
            entity.setPostalCode(dto.getPostalCode());
            entity.setCity(dto.getCity());
            entity.setCountry(dto.getCountry());
            entity.setContactPerson(dto.getContactPerson());
            entity.setDescGreek(dto.getDescGreek());
            entity.setDescEnglish(dto.getDescEnglish());
            entity.setLogoId(dto.getLogoId());
            if(dto.getStatus().equals(ApplicationState.PENDING)) entity.setStatus(ApplicationState.PENDING);
            else if(dto.getStatus().equals(ApplicationState.APPROVED)) entity.setStatus(ApplicationState.APPROVED);
            else if(dto.getStatus().equals(ApplicationState.DISAPPROVED)) entity.setStatus(ApplicationState.DISAPPROVED);
            entity.setHiddenYN(dto.isHiddenYN());
            entity.setSocialMediaList(new ArrayList<SocialMedium>());
            if(entity.getSocialMediaList() != null && !dto.getSocialMediaList().isEmpty())
            {
                for (SocialMediumDTO temp : dto.getSocialMediaList()) {
                    entity.getSocialMediaList().add(SocialMediumDAOImplementation.transformSocialMediumDTO2Entity(temp));
                }
            }
            entity.setTelephone(dto.getTelephone());
            entity.setEmail(dto.getEmail());
            entity.setAccountUpdated(Utilities.ft.format(new Date()));
            em.persist(entity);
            em.getTransaction().commit();
            result = SUCCESS;
        }   catch (Exception e){
            em.getTransaction().rollback();
            result = ERROR;
        }
        finally{
            em.close();
            factory.close();
        }
        return result;
    }


    /********************************************************************************************************************
     Updates an existing Ngo entity in the database to mark it as Hidden (from the volunteers).
     Probable reasons: it is outdated, it is unacceptable, it was asked etc.
     Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
     *******************************************************************************************************************/

    public boolean markNgoAsHidden(NgoDTO dto){

        if(dto.getDatabaseID() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try{
            em.getTransaction().begin();
            Ngo entity = em.find( Ngo.class, dto.getDatabaseID());
            entity.setHiddenYN(true);
            entity.setAccountUpdated(Utilities.ft.format(new Date()));
            em.persist(entity);
            em.getTransaction().commit();
            result = SUCCESS;
        }   catch (Exception e){
            em.getTransaction().rollback();
            result = ERROR;
        }
        finally{
            em.close();
            factory.close();
        }
        return result;
    }


    /********************************************************************************************************************
     Updates an existing Ngo entity in the database to mark it as NotHidden (from the volunteers).
     Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
     *******************************************************************************************************************/

    public boolean markNgoAsNotHidden(NgoDTO dto){

        if(dto.getDatabaseID() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try{
            em.getTransaction().begin();
            Ngo entity = em.find( Ngo.class, dto.getDatabaseID());
            entity.setHiddenYN(false);
            entity.setAccountUpdated(Utilities.ft.format(new Date()));
            em.persist(entity);
            em.getTransaction().commit();
            result = SUCCESS;
        }   catch (Exception e){
            em.getTransaction().rollback();
            result = ERROR;
        }
        finally{
            em.close();
            factory.close();
        }
        return result;
    }


    /********************************************************************************************************************
     Updates an existing Ngo entity in the database to mark it as Approved + Not Hidden (by Ethelon admin).
     Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
     *******************************************************************************************************************/

    public boolean markNgoAsApproved(NgoDTO dto){

        if(dto.getDatabaseID() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try{
            em.getTransaction().begin();
            Ngo entity = em.find( Ngo.class, dto.getDatabaseID());
            entity.setHiddenYN(false);
            entity.setStatus(ApplicationState.APPROVED);
            entity.setAccountUpdated(Utilities.ft.format(new Date()));
            em.persist(entity);
            em.getTransaction().commit();
            result = SUCCESS;
        }   catch (Exception e){
            em.getTransaction().rollback();
            result = ERROR;
        }
        finally{
            em.close();
            factory.close();
        }
        return result;
    }


    /********************************************************************************************************************
     Updates an existing Ngo entity in the database to mark it as Disapproved + Hidden (by Ethelon admin).
     Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
     *******************************************************************************************************************/

    public boolean markNgoAsDisapproved(NgoDTO dto){

        if(dto.getDatabaseID() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try{
            em.getTransaction().begin();
            Ngo entity = em.find( Ngo.class, dto.getDatabaseID());
            entity.setHiddenYN(true);
            entity.setStatus(ApplicationState.DISAPPROVED);
            entity.setAccountUpdated(Utilities.ft.format(new Date()));
            em.persist(entity);
            em.getTransaction().commit();
            result = SUCCESS;
        }   catch (Exception e){
            em.getTransaction().rollback();
            result = ERROR;
        }
        finally{
            em.close();
            factory.close();
        }
        return result;
    }


    /********************************************************************************************************************
     Returns the full list of Ngos. Returns null if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<NgoDTO> getFullListOfNgos()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<NgoDTO> ngoDTOList = new ArrayList<NgoDTO>();

        try {
            Query q = em.createQuery("SELECT n FROM Ngo n where 1=1 ");
            List<Ngo> entityList = q.getResultList();
            NgoDTO temp;

            if (entityList.size() != 0) {
                for (Ngo current : entityList) {
                    temp = transformNgoEntity2DTO(current);
                    temp.setDatabaseID(current.getUserID());
                    ngoDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            ngoDTOList = null;
        } finally {
            em.close();
            factory.close();
        }

        return ngoDTOList;
    }


    /********************************************************************************************************************
     Returns the full list of Ngos that have not uploaded opportunities after a given date. Returns null
     if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<NgoDTO> getFullListOfInactiveNgos(Date date)
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<NgoDTO> ngoDTOList = new ArrayList<NgoDTO>();

        try {
            Query q = em.createQuery("SELECT n FROM Ngo n where 1=1 ");
            List<Ngo> entityList = q.getResultList();
            NgoDTO temp;
            Date dateToTest = new Date();

            if (entityList.size() != 0) {
                for (Ngo current : entityList) {
                    try {
                        dateToTest = Utilities.ft.parse(current.getLastOpportunityUpload());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if(dateToTest.after(date)) continue;
                    temp = transformNgoEntity2DTO(current);
                    temp.setDatabaseID(current.getUserID());
                    ngoDTOList.add(temp);
                }
                if(ngoDTOList.size() == 0) ngoDTOList = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ngoDTOList = null;
        } finally {
            em.close();
            factory.close();
        }

        return ngoDTOList;
    }

    public NgoDTO validateNgo(String username, String password){

        if(username==null||password==null) return null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Ngo entity;
        NgoDTO ngoDto;

        try {
            Query query= em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            entity = (Ngo) query.getSingleResult();
            ngoDto = transformNgoEntity2DTO(entity);


        } catch(Exception e) {
            ngoDto=null;
        }


        finally {
            em.close();
            factory.close();
        }

        return ngoDto;
    }



    /******************************************************************************************************************
     Utility: Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).

     Note: opportunitiesList, lastOpportunityUpload, loggedInLast, accountCreated, accountUpdated are never
     transported, through a DTO towards the database.
     Social Media entities are provided by the database, only the ID is used from the DTO.
     *****************************************************************************************************************/

    public static Ngo transformNgoDTO2Entity(NgoDTO dto) {
        Ngo entity = new Ngo();
        entity.setOrganizationName(dto.getOrganizationName());
        entity.setWebpage(dto.getWebpage());
        entity.setAddress(dto.getAddress());
        entity.setStreetNo(dto.getStreetNo());
        entity.setPostalCode(dto.getPostalCode());
        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());
        entity.setContactPerson(dto.getContactPerson());
        entity.setDescGreek(dto.getDescGreek());
        entity.setDescEnglish(dto.getDescEnglish());
        entity.setLogoId(dto.getLogoId());
        if(dto.getStatus() != null) {
            if (dto.getStatus().equals(ApplicationState.PENDING)) entity.setStatus(ApplicationState.PENDING);
            else if (dto.getStatus().equals(ApplicationState.APPROVED)) entity.setStatus(ApplicationState.APPROVED);
            else if (dto.getStatus().equals(ApplicationState.DISAPPROVED))
                entity.setStatus(ApplicationState.DISAPPROVED);
        }
        entity.setHiddenYN(dto.isHiddenYN());
        entity.setSocialMediaList(new ArrayList<SocialMedium>());
        if(entity.getSocialMediaList() != null && dto.getSocialMediaList() != null && !dto.getSocialMediaList().isEmpty())
        {
            for (SocialMediumDTO temp : dto.getSocialMediaList()) {
                entity.getSocialMediaList().add(SocialMediumDAOImplementation.transformSocialMediumDTO2Entity(temp));
            }
        }
        entity.setUserID(dto.getDatabaseID());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setTelephone(dto.getTelephone());
        entity.setEmail(dto.getEmail());
        return entity;
    }


    /******************************************************************************************************************
     Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static NgoDTO transformNgoEntity2DTO(Ngo entity) {
        NgoDTO dto = new NgoDTO();
        dto.setOrganizationName(entity.getOrganizationName());
        dto.setWebpage(entity.getWebpage());
        dto.setAddress(entity.getAddress());
        dto.setStreetNo(entity.getStreetNo());
        dto.setPostalCode(entity.getPostalCode());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        dto.setContactPerson(entity.getContactPerson());
        dto.setDescGreek(entity.getDescGreek());
        dto.setDescEnglish(entity.getDescEnglish());
        dto.setLogoId(entity.getLogoId());
        if(entity.getStatus() != null) {
            if (entity.getStatus().equals(ApplicationState.PENDING)) dto.setStatus(ApplicationState.PENDING);
            else if (entity.getStatus().equals(ApplicationState.APPROVED)) dto.setStatus(ApplicationState.APPROVED);
            else if (entity.getStatus().equals(ApplicationState.DISAPPROVED))
                dto.setStatus(ApplicationState.DISAPPROVED);
        }
        dto.setHiddenYN(entity.isHiddenYN());
        dto.setOpportunitiesList(new ArrayList<OpportunityDTO>());
        if(dto.getOpportunitiesList() != null && entity.getSocialMediaList() != null && !entity.getOpportunitiesList().isEmpty())
        {
            for (Opportunity temp : entity.getOpportunitiesList()) {
                dto.getOpportunitiesList().add(OpportunityDAOImplementation.transformOpportunityEntity2DTO(temp));
            }
        }
        dto.setSocialMediaList(new ArrayList<SocialMediumDTO>());
        if(dto.getSocialMediaList() != null && !entity.getSocialMediaList().isEmpty())
        {
            for (SocialMedium temp : entity.getSocialMediaList()) {
                dto.getSocialMediaList().add(SocialMediumDAOImplementation.transformSocialMediumEntity2DTO(temp));
            }
        }

        dto.setDatabaseID(entity.getUserID());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setTelephone(entity.getTelephone());
        dto.setEmail(entity.getEmail());
        try {
            dto.setLastOpportunityUpload(Utilities.ft.parse(entity.getLastOpportunityUpload()));
            dto.setLoggedInLast(Utilities.ft.parse(entity.getLoggedInLast()));
            dto.setAccountCreated(Utilities.ft.parse(entity.getAccountCreated()));
            dto.setAccountUpdated(Utilities.ft.parse(entity.getAccountUpdated()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dto;
    }


    /******************************************************************************************************************
     Utility: Returns a Ngo entity as persisted in the database when the databaseID is known.
     *****************************************************************************************************************/

    public static Ngo findNgoById(int databaseID)
    {
        if(databaseID == 0) return null;

        Ngo entity;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            entity = em.find( Ngo.class, databaseID );
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
