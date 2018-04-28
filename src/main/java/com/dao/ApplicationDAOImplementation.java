package com.dao;

import com.database.Application;
import com.database.ApplicationState;
import com.database.Opportunity;
import com.database.Volunteer;
import com.dto.ApplicationDTO;
import com.dto.OpportunityDTO;
import com.dto.VolunteerDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class ApplicationDAOImplementation implements ApplicationDAO {

    private static final boolean SUCCESS = true;
    private static final boolean ERROR = false;

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";


    /********************************************************************************************************************
     Inserts a new Application entity in the database. Associates the Application with an already existing Opportunity.
     Uses DTOs as input.
     *******************************************************************************************************************/

    public boolean insertApplicationForOpportunity(ApplicationDTO applicationDTO, OpportunityDTO opportunityDTO, VolunteerDTO volunteerDTO)
    {
        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Application application = transformApplicationDTO2Entity(applicationDTO);
            application.setInsertDate(Utilities.ft.format(new Date()));
            application.setStatus(ApplicationState.PENDING);
            application.setStatusUpdate(Utilities.ft.format(new Date()));

            em.persist(application);

            Opportunity opportunity = em.find(Opportunity.class, opportunityDTO.getDatabaseId());
            List<Application> list = opportunity.getApplicationsList();
            list.add(application);
            opportunity.setApplicationsList(list);
            em.persist(opportunity);

            application.setOpportunity(opportunity);
            em.persist(application);

            Volunteer volunteer = em.find(Volunteer.class, volunteerDTO.getDatabaseID());
            application.setVolunteer(volunteer);
            em.persist(application);

            volunteer.getPendingApplicationsList().add(application);
            volunteer.getApplicationsList().add(application);
            volunteer.setAppliedLast(Utilities.ft.format(new Date()));
            em.persist(volunteer);

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
     Returns the Opportunity that an Application addresses.
     *******************************************************************************************************************/

    public OpportunityDTO getRelatedOpportunityOfApplication(ApplicationDTO applicationDTO)
    {
        if(applicationDTO.getDatabaseId() == 0) return null;

        OpportunityDTO oppDTO = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Application entity = em.find( Application.class, applicationDTO.getDatabaseId() );
            oppDTO = OpportunityDAOImplementation.transformOpportunityEntity2DTO(entity.getOpportunity());
        } catch(Exception e) {
            em.getTransaction().rollback();
        }
        finally {
            em.close();
            factory.close();
        }

        return oppDTO;
    }


    /********************************************************************************************************************
     Returns the Volunteer that has created an Application.
     *******************************************************************************************************************/

    public VolunteerDTO getRelatedVolunteerOfApplication(ApplicationDTO applicationDTO)
    {
        if(applicationDTO.getDatabaseId() == 0) return null;

        VolunteerDTO volunteerDTO = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Application entity = em.find( Application.class, applicationDTO.getDatabaseId() );
            volunteerDTO = VolunteerDAOImplementation.transformVolunteerEntity2DTO(entity.getVolunteer());
        } catch(Exception e) {
            em.getTransaction().rollback();
        }
        finally {
            em.close();
            factory.close();
        }

        return volunteerDTO;
    }

    /******************************************************************************************************************
     Alters status of an application as "Pending" (this is also default upon insertion).
     *****************************************************************************************************************/

    public boolean markApplicationAsPending(ApplicationDTO applicationDTO) {
        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        //VolunteerDAOImplementation vdimp = new VolunteerDAOImplementation();

        try {
            em.getTransaction().begin();
            Application application = em.find( Application.class, applicationDTO.getDatabaseId());
            application.setStatus(ApplicationState.PENDING);
            application.setStatusUpdate(Utilities.ft.format(new Date()));
            em.persist(application);

            Volunteer volunteer = em.find(Volunteer.class, application.getVolunteer().getUserID());
            if(!VolunteerDAOImplementation.isVolunteerRelatedToApplication(volunteer, application)) volunteer.getApplicationsList().add(application);
            VolunteerDAOImplementation.refreshPendingApplicationsList(volunteer);
            volunteer.setAppliedLast(Utilities.ft.format(new Date()));
            em.persist(volunteer);

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


    /******************************************************************************************************************
     Alters status of an application as "Approved by NGO".
     *****************************************************************************************************************/

    public boolean markApplicationAsApproved(ApplicationDTO applicationDTO) {
        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Application application = em.find( Application.class, applicationDTO.getDatabaseId());
            application.setStatus(ApplicationState.APPROVED);
            application.setStatusUpdate(Utilities.ft.format(new Date()));
            em.persist(application);

            Volunteer volunteer = em.find(Volunteer.class, application.getVolunteer().getUserID());
            if(!VolunteerDAOImplementation.isVolunteerRelatedToApplication(volunteer, application)) volunteer.getApplicationsList().add(application);
            VolunteerDAOImplementation.refreshPendingApplicationsList(volunteer);
            em.persist(volunteer);

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


    /******************************************************************************************************************
     Alters status of an application as "Disapproved by NGO".
     *****************************************************************************************************************/

    public boolean markApplicationAsDisapproved(ApplicationDTO applicationDTO) {
        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Application application = em.find( Application.class, applicationDTO.getDatabaseId());
            application.setStatus(ApplicationState.DISAPPROVED);
            application.setStatusUpdate(Utilities.ft.format(new Date()));
            em.persist(application);

            Volunteer volunteer = em.find(Volunteer.class, application.getVolunteer().getUserID());
            if(!VolunteerDAOImplementation.isVolunteerRelatedToApplication(volunteer, application)) volunteer.getApplicationsList().add(application);
            VolunteerDAOImplementation.refreshPendingApplicationsList(volunteer);
            em.persist(volunteer);

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


    /******************************************************************************************************************
     Alters status of an application as "Withdrawn By Volunteer".
     *****************************************************************************************************************/

    public boolean markApplicationAsWithdrawnByVolunteer(ApplicationDTO applicationDTO) {
        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Application application = em.find( Application.class, applicationDTO.getDatabaseId());
            application.setStatus(ApplicationState.WITHDRAWN);
            application.setStatusUpdate(Utilities.ft.format(new Date()));
            em.persist(application);

            Volunteer volunteer = em.find(Volunteer.class, application.getVolunteer().getUserID());
            if(!VolunteerDAOImplementation.isVolunteerRelatedToApplication(volunteer, application)) volunteer.getApplicationsList().add(application);
            VolunteerDAOImplementation.refreshPendingApplicationsList(volunteer);
            em.persist(volunteer);

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


    /******************************************************************************************************************
     Alters status of an application as "Cancelled By Administrator".
     *****************************************************************************************************************/

    public boolean markApplicationAsCancelledByAdministrator(ApplicationDTO applicationDTO) {
        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Application application = em.find( Application.class, applicationDTO.getDatabaseId());
            application.setStatus(ApplicationState.CANCELLED);
            application.setStatusUpdate(Utilities.ft.format(new Date()));
            em.persist(application);

            Volunteer volunteer = em.find(Volunteer.class, application.getVolunteer().getUserID());
            if(!VolunteerDAOImplementation.isVolunteerRelatedToApplication(volunteer, application)) volunteer.getApplicationsList().add(application);
            VolunteerDAOImplementation.refreshPendingApplicationsList(volunteer);
            em.persist(volunteer);

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


    /******************************************************************************************************************
     Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static ApplicationDTO transformApplicationEntity2DTO(Application entity)
    {
        ApplicationDTO dto = new ApplicationDTO();
        dto.setDatabaseId(entity.getApplicationID());
        dto.setStatus(entity.getStatus());
        dto.setAvailability(entity.getAvailability());
        dto.setComments(entity.getComments());
        try {
            dto.setStatusUpdate(Utilities.ft.parse(entity.getStatusUpdate()));
            dto.setInsertDate(Utilities.ft.parse(entity.getInsertDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dto;
        // Note: the cvIdentifier is never transported through a DTO towards the front-end.
    }


    /******************************************************************************************************************
     Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).
     *****************************************************************************************************************/

    public static Application transformApplicationDTO2Entity(ApplicationDTO dto)
    {
        Application entity = new Application();
        entity.setApplicationID(dto.getDatabaseId());
        entity.setCvIdentifier(dto.getCvIdentifier());
        entity.setAvailability(dto.getAvailability());
        entity.setComments(dto.getComments());
        return entity;
        // Note: Status, StatusUpdate, InsertDate are never transported through a DTO towards the database.
    }
}
