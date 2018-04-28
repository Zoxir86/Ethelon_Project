package com.dao;

import com.database.*;
import com.dto.ApplicationDTO;
import com.dto.InterestDTO;
import com.dto.KnowledgeAreaDTO;
import com.dto.VolunteerDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;


public class VolunteerDAOImplementation implements VolunteerDAO {

    private static final boolean SUCCESS = true;
    private static final boolean ERROR = false;

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";



    /********************************************************************************************************************
     Inserts a new Volunteer entity in the database. Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
     *******************************************************************************************************************/

    public boolean insertVolunteer(VolunteerDTO dto) {

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Volunteer entity = transformVolunteerDTO2Entity(dto);
            entity.setEthelonVolunteerYN(false);
            entity.setApplicationsList(new ArrayList<Application>());
            entity.setPendingApplicationsList(new ArrayList<Application>());
            entity.setInterestsList(new ArrayList<Interest>());
            entity.setKnowledgeAreasList(new ArrayList<KnowledgeArea>());
            entity.setAccountCreated(Utilities.ft.format(new Date()));
            entity.setAccountUpdated(Utilities.ft.format(new Date()));
            entity.setAppliedLast("");
            entity.setLoggedInLast(Utilities.ft.format(new Date()));
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
     Deletes an existing Volunteer entity in the database. Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
     *******************************************************************************************************************/

    public boolean deleteVolunteer(VolunteerDTO dto) {

        if(dto.getDatabaseID() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Volunteer entity = em.find( Volunteer.class, dto.getDatabaseID() );
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
     Updates an existing Volunteer entity in the database. Uses a DTO as input.

     Note1: isEthelonVolunter, appliedLast, applicationsList, pendingApplicationsList, databaseID, username,
     password, accountCreated, loggedInLast are not updated through this method.
     Note2: Area/Interests/KnowledgeAreas entities are provided by the database, only the ID
     is used from the DTO.

     Returns SUCCESS (true) or ERROR (false).
     *******************************************************************************************************************/

    public boolean updateVolunteer(VolunteerDTO dto) {

        if(dto.getDatabaseID() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try{
            em.getTransaction().begin();
            Volunteer entity = em.find( Volunteer.class, dto.getDatabaseID() );

            entity.setName(dto.getName());
            entity.setSurname(dto.getSurname());
            entity.setDateOfBirth(Utilities.ft.format(dto.getDateOfBirth()));
            if(dto.getSex().equals(Sex.MALE)) entity.setSex(Sex.MALE);
            else if(dto.getSex().equals(Sex.FEMALE)) entity.setSex(Sex.FEMALE);
            else entity.setSex(Sex.UNKNOWN);
            entity.setVolunteerYN(dto.isVolunteerYN());
            if(dto.getArea() != null)entity.setArea(AreaDAOImplementation.findAreaById(dto.getArea().getDatabaseID()));
            entity.setInterestsList(new ArrayList<Interest>());
            if(dto.getInterestsList() != null && !dto.getInterestsList().isEmpty())
            {
                for (InterestDTO temp : dto.getInterestsList()) {
                    entity.getInterestsList().add(InterestDAOImplementation.findInterestById(temp.getDatabaseId()));
                }
            }
            entity.setKnowledgeAreasList(new ArrayList<KnowledgeArea>());
            if(dto.getKnowledgeAreasList() != null && !dto.getKnowledgeAreasList().isEmpty())
            {
                for (KnowledgeAreaDTO temp : dto.getKnowledgeAreasList()) {
                    entity.getKnowledgeAreasList().add(KnowledgeAreaDAOImplementation.findKnowledgeAreaById(temp.getDatabaseId()));
                }
            }
            entity.setOtherKnowledge(dto.getOtherKnowledge());
            entity.setTelephone(dto.getTelephone());
            entity.setEmail(dto.getEmail());
            entity.setAccountUpdated(Utilities.ft.format(new Date()));
            em.persist(entity);
            em.getTransaction().commit();
            result = true;

        }   catch(Exception e){
            em.getTransaction().rollback();
            result = false;
        }
        finally {
            em.close();
            factory.close();
        }
        return result;
    }


    /******************************************************************************************************************
     Returns a Volunteer entity as persisted in the database when the databaseID is known.
     *****************************************************************************************************************/

    public Volunteer findVolunteerById(int databaseID)
    {
        if(databaseID == 0) return null;

        Volunteer entity;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            entity = em.find( Volunteer.class, databaseID );
        } catch(Exception e) {
            entity = null;
        }
        finally {
            em.close();
            factory.close();
        }

        return entity;
    }


    /******************************************************************************************************************
     Utility: Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).

     Note: appliedLast, applicationsList, pendingApplicationsList, loggedInLast, accountCreated,
     accountUpdated are never transported through a DTO towards the database.
     Area/Interests/KnowledgeAreas/isEthelonVolunteerYN entities are provided by the database, only the ID
     is used from the DTO.
     *****************************************************************************************************************/

    public static Volunteer transformVolunteerDTO2Entity(VolunteerDTO dto) {

        Volunteer entity = new Volunteer();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setDateOfBirth(Utilities.ft.format(dto.getDateOfBirth()));
        if(dto.getSex().equals(Sex.MALE)) entity.setSex(Sex.MALE);
        else if(dto.getSex().equals(Sex.FEMALE)) entity.setSex(Sex.FEMALE);
        else entity.setSex(Sex.UNKNOWN);
        entity.setVolunteerYN(dto.isVolunteerYN());
        if(dto.getArea() != null) entity.setArea(AreaDAOImplementation.findAreaById(dto.getArea().getDatabaseID()));
        entity.setInterestsList(new ArrayList<Interest>());
        if(dto.getInterestsList() != null && !dto.getInterestsList().isEmpty())
        {
            for (InterestDTO temp : dto.getInterestsList()) {
                entity.getInterestsList().add(InterestDAOImplementation.findInterestById(temp.getDatabaseId()));
            }
        }
        entity.setKnowledgeAreasList(new ArrayList<KnowledgeArea>());
        if(dto.getKnowledgeAreasList() != null && !dto.getKnowledgeAreasList().isEmpty())
        {
            for (KnowledgeAreaDTO temp : dto.getKnowledgeAreasList()) {
                entity.getKnowledgeAreasList().add(KnowledgeAreaDAOImplementation.findKnowledgeAreaById(temp.getDatabaseId()));
            }
        }
        entity.setOtherKnowledge(dto.getOtherKnowledge());
        entity.setUserID(dto.getDatabaseID());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setTelephone(dto.getTelephone());
        entity.setEmail(dto.getEmail());
        return entity;
    }


    /******************************************************************************************************************
     Utility: Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static VolunteerDTO transformVolunteerEntity2DTO(Volunteer entity) {

        VolunteerDTO dto = new VolunteerDTO();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        if(entity.getSex().equals(Sex.MALE)) dto.setSex(Sex.MALE);
        else if(entity.getSex().equals(Sex.FEMALE)) dto.setSex(Sex.FEMALE);
        else dto.setSex(Sex.UNKNOWN);
        dto.setVolunteerYN(entity.isVolunteerYN());
        if(entity.getArea() != null) dto.setArea(AreaDAOImplementation.transformAreaEntity2DTO(entity.getArea()));
        dto.setApplicationsList(new ArrayList<ApplicationDTO>());
        if(dto.getApplicationsList() != null && !entity.getApplicationsList().isEmpty())
        {
            for (Application temp : entity.getApplicationsList()) {
                dto.getApplicationsList().add(ApplicationDAOImplementation.transformApplicationEntity2DTO(temp));
            }
            dto.setEthelonVolunteerYN(true);
        }
        dto.setPendingApplicationsList(new ArrayList<ApplicationDTO>());
        if(dto.getPendingApplicationsList() != null && !entity.getPendingApplicationsList().isEmpty())
        {
            for (Application temp : entity.getPendingApplicationsList()) {
                dto.getPendingApplicationsList().add(ApplicationDAOImplementation.transformApplicationEntity2DTO(temp));
            }
        }
        dto.setInterestsList(new ArrayList<InterestDTO>());
        if(dto.getInterestsList() != null && !entity.getInterestsList().isEmpty())
        {
            for (Interest temp : entity.getInterestsList()) {
                dto.getInterestsList().add(InterestDAOImplementation.transformInterestEntity2DTO(temp));
            }
        }
        dto.setKnowledgeAreasList(new ArrayList<KnowledgeAreaDTO>());
        if(dto.getKnowledgeAreasList() != null && !entity.getKnowledgeAreasList().isEmpty())
        {
            for (KnowledgeArea temp : entity.getKnowledgeAreasList()) {
                dto.getKnowledgeAreasList().add(KnowledgeAreaDAOImplementation.transformKnowledgeAreaEntity2DTO(temp));
            }
        }
        dto.setOtherKnowledge(entity.getOtherKnowledge());
        dto.setDatabaseID(entity.getUserID());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setTelephone(entity.getTelephone());
        try {
            dto.setDateOfBirth(Utilities.ft.parse(entity.getDateOfBirth()));
            dto.setAppliedLast(Utilities.ft.parse(entity.getAppliedLast()));
            dto.setLoggedInLast(Utilities.ft.parse(entity.getLoggedInLast()));
            dto.setAccountCreated(Utilities.ft.parse(entity.getAccountCreated()));
            dto.setAccountUpdated(Utilities.ft.parse(entity.getAccountUpdated()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dto;
    }


    /******************************************************************************************************************
     Utility: Checks whether an application belongs to a particular volunteer.
     *****************************************************************************************************************/

    public static boolean isVolunteerRelatedToApplication(Volunteer volunteer, Application application) {
        return volunteer.getApplicationsList().stream().anyMatch(app -> app.getApplicationID() == application.getApplicationID());
    }


    /******************************************************************************************************************
     Utility: Refreshes the pending applications list of a particular volunteer.
     *****************************************************************************************************************/

    public static void refreshPendingApplicationsList(Volunteer volunteer) {
        volunteer.setPendingApplicationsList(new ArrayList<Application>());
        for (Application temp : volunteer.getApplicationsList()) {
            if(temp.getStatus().equals(ApplicationState.PENDING)) volunteer.getPendingApplicationsList().add(temp);
        }
    }


}
