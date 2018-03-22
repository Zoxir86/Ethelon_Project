package com.dao;

import com.dto.VolunteerDTO;
import com.database.Volunteer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;


public class VolunteerDAOImplementation implements VolunteerDAO {

    // Tools required for the JPA toolset (in this application EclipseLink is being used).
    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";
    private static EntityManagerFactory factory;
    EntityManager em;

    public VolunteerDAOImplementation() {

    }


    /********************************************************************************************************************
     Insert a new Volunteer entity in the database. Uses a DTO as input. It also manages transactions so as to permit
     rollback on failures.
     *******************************************************************************************************************/

    public boolean insertVolunteer(VolunteerDTO volunteer) {

        boolean result;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Volunteer entity = transformVolunteerDTO2Entity(volunteer);
            entity.setAccountCreated(Utilities.ft.format(new Date()));
            em.persist(entity);
            em.getTransaction().commit();
            result = true;
        } catch(Exception e) {
            em.getTransaction().rollback();
            result = false;
        }
        finally {
            em.close();
            factory.close();
        }

        return result;
    }


    /********************************************************************************************************************
     Deletes an existing Volunteer entity in the database. Uses a DTO as input. It also manages transactions so as to
     permit rollback on failures.
     *******************************************************************************************************************/

   public boolean deleteVolunteer(VolunteerDTO volunteer) {

       if(volunteer.getDatabaseID() == 0) return false;

        boolean result;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Volunteer entity = em.find( Volunteer.class, volunteer.getDatabaseID() );
            em.remove(entity);
            em.getTransaction().commit();
            result = true;
        } catch(Exception e) {
            em.getTransaction().rollback();
            result = false;
        }
        finally {
            em.close();
            factory.close();
        }

        return result;
    }


    /********************************************************************************************************************
     Updates an existing Volunteer entity in the database. Uses a DTO as input. It also manages transactions so as to
     permit rollback on failures.
     *******************************************************************************************************************/

    public boolean updateVolunteer(VolunteerDTO volunteer) {

        if(volunteer.getDatabaseID() == 0) return false;

        boolean result;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        try{
            em.getTransaction().begin();
            Volunteer entity = em.find( Volunteer.class, volunteer.getDatabaseID() );
            entity.setName(volunteer.getName());
            entity.setSurname(volunteer.getSurname());
            entity.setDateOfBirth(Utilities.ft.format(volunteer.getDateOfBirth()));
            entity.setMale(volunteer.isMale());
            entity.setFemale(volunteer.isFemale());
            entity.setArea(volunteer.getArea());
            //entity.setOccupation(volunteer.getOccupation());   //TODO waiting implementation
            //entity.setInterests(volunteer.getInterests());
            entity.setAppliedLast(Utilities.ft.format(volunteer.getAppliedLast()));
            entity.setUsername(volunteer.getUsername());
            entity.setPassword(volunteer.getPassword());
            entity.setTelephone(volunteer.getTelephone());
            entity.setEmail(volunteer.getEmail());
            entity.setLoggedInLast(Utilities.ft.format(volunteer.getLoggedInLast()));
            entity.setAccountCreated(Utilities.ft.format(volunteer.getAccountCreated()));
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
     Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).
     *****************************************************************************************************************/

    public static Volunteer transformVolunteerDTO2Entity(VolunteerDTO volunteer) {

        Volunteer entity = new Volunteer();
        entity.setName(volunteer.getName());
        entity.setSurname(volunteer.getSurname());
        entity.setDateOfBirth(Utilities.ft.format(volunteer.getDateOfBirth()));
        entity.setMale(volunteer.isMale());
        entity.setFemale(volunteer.isFemale());
        entity.setArea(volunteer.getArea());
        //entity.setOccupation(volunteer.getOccupation());
        //entity.setInterests(volunteer.getInterests());
        //entity.setAppliedLast(Utilities.ft.format(volunteer.getAppliedLast()));
        entity.setUsername(volunteer.getUsername());
        entity.setPassword(volunteer.getPassword());
        entity.setTelephone(volunteer.getTelephone());
        entity.setEmail(volunteer.getEmail());
        //entity.setLoggedInLast(Utilities.ft.format(volunteer.getLoggedInLast()));
        //entity.setAccountCreated(Utilities.ft.format(volunteer.getAccountCreated()));
        return entity;
    }


    /******************************************************************************************************************
     Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static VolunteerDTO transformVolunteerEntity2DTO(Volunteer volunteer) {

        VolunteerDTO dto = new VolunteerDTO();
        dto.setName(volunteer.getName());
        dto.setSurname(volunteer.getSurname());
        dto.setMale(volunteer.isMale());
        dto.setFemale(volunteer.isFemale());
        dto.setArea(volunteer.getArea());
        //dto.setOccupation(volunteer.getOccupation());
        //dto.setInterests(volunteer.getInterests());
        dto.setUsername(volunteer.getUsername());
        dto.setPassword(volunteer.getPassword());
        dto.setTelephone(volunteer.getTelephone());
        dto.setEmail(volunteer.getEmail());
        try {
            dto.setDateOfBirth(Utilities.ft.parse(volunteer.getDateOfBirth()));
            dto.setLoggedInLast(Utilities.ft.parse(volunteer.getLoggedInLast()));
            dto.setAccountCreated(Utilities.ft.parse(volunteer.getAccountCreated()));
            dto.setAppliedLast(Utilities.ft.parse(volunteer.getAppliedLast()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dto;
    }

    /*  TODO Check functionality and/or transform to SearchByID.
        public ArrayList<VolunteerDTO> searchVolunteer(String name, String surname, Date dateOfBirth) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        ArrayList<VolunteerDTO> result = new ArrayList<VolunteerDTO>();

        String nameparam = name.concat("%");
        String surnameparam = surname.concat("%");



        Query q = em.createQuery("SELECT v FROM Volunteer v WHERE v.name LIKE :name AND v.surname LIKE :surname AND v.dateOfBirth LIKE :dateOfBirth"); // ?? import java.sql.Date instead of  java.util.date ??
        q.setParameter("name", nameparam);
        q.setParameter("surname", surnameparam);
        q.setParameter("dateOfBirth", dateOfBirth);
        List<Volunteer> volunteerList = q.getResultList();
        VolunteerDTO temp;

        if(volunteerList.size() != 0) {
            for (Volunteer current : volunteerList) {
                temp = transformVolunteerEntity2DTO(current);
                temp.setUserID(current.getUserID());
                result.add(temp);
            }
        }
        em.close();
        factory.close();

        return result;
        }
     */
}
