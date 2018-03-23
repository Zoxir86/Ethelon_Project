package com.dao;

import com.dto.NgoDTO;
import com.database.Ngo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NgoDAOImplementation implements NgoDAO {

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";
    private static EntityManagerFactory factory;
    EntityManager em;

    public NgoDAOImplementation(){

    }


    /********************************************************************************************************************
     Insert a new Ngo entity in the database. Uses a DTO as input. It also manages transactions so as to permit
     rollback on failures.
     *******************************************************************************************************************/

    public boolean insertNgo(NgoDTO ngo) {

        boolean result;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        try{
            em.getTransaction().begin();
            Ngo entity = transformNgoDTO2Entity(ngo);
            entity.setAccountCreated(Utilities.ft.format(new Date()));
            em.persist(entity);
            em.getTransaction().commit();
            result = true;
        } catch (Exception e){
            em.getTransaction().rollback();
            result = false;
        } finally {
            em.close();
            factory.close();
        }
        return result;
    }


    /********************************************************************************************************************
     Deletes an existing Volunteer entity in the database. Uses a DTO as input. It also manages transactions so as to
     permit rollback on failures.
     *******************************************************************************************************************/

    public boolean deleteNgo(NgoDTO ngo){
        if(ngo.getDatabaseID() == 0) return false;                  // TODO maybe userID instead?

        boolean result;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        try{
            em.getTransaction().begin();
            Ngo entity = em.find(Ngo.class, ngo.getDatabaseID());
            em.remove(entity);
            em.getTransaction().commit();
            result = true;
        } catch (Exception e){
            em.getTransaction().rollback();
            result = false;
        } finally {
            em.close();
            factory.close();
        }
        return result;
    }


    /********************************************************************************************************************
     Updates an existing Volunteer entity in the database. Uses a DTO as input. It also manages transactions so as to
     permit rollback on failures.
     *******************************************************************************************************************/

    public boolean updateNgo(NgoDTO ngo){
        if(ngo.getDatabaseID() == 0) return false;                  // TODO maybe userID instead?

        boolean result;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        try{
            em.getTransaction().begin();
            Ngo entity = em.find( Ngo.class, ngo.getDatabaseID());
            entity.setOrganizationName(ngo.getOrganizationName());
            entity.setWebpage(ngo.getWebpage());
            entity.setAddress(ngo.getAddress());
            entity.setStreetNo(ngo.getStreetNo());
            entity.setPostalCode(ngo.getPostalCode());
            entity.setCity(ngo.getCity());
            entity.setCountry(ngo.getCountry());
            entity.setContactPerson(ngo.getContactPerson());
            entity.setDescGreek(ngo.getDescGreek());
            entity.setDescEnglish(ngo.getDescEnglish());
            entity.setSocialMedium1(ngo.getSocialMedium1());               // TODO transform these to entities. Sylvia has given specific ones, but they may change in the future.
            entity.setSocialMedium2(ngo.getSocialMedium2());
            entity.setSocialMedium3(ngo.getSocialMedium3());
            entity.setLogoId(ngo.getLogoId());
            entity.setLastOpportunityUpload(Utilities.ft.format(ngo.getLastOpportunityUpload()));
            entity.setUsername(ngo.getUsername());
            entity.setPassword(ngo.getPassword());
            entity.setTelephone(ngo.getTelephone());
            entity.setEmail(ngo.getEmail());
            entity.setLoggedInLast(Utilities.ft.format(ngo.getLoggedInLast()));
            entity.setAccountCreated(Utilities.ft.format(ngo.getAccountCreated()));
            em.persist(entity);
            em.getTransaction().commit();
            result = true;

        }   catch (Exception e){
            em.getTransaction().rollback();
            result = false;
        }
        finally{
            em.close();
            factory.close();
        }
        return result;
    }


    /******************************************************************************************************************
     Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).
     *****************************************************************************************************************/

    public static Ngo transformNgoDTO2Entity(NgoDTO ngo) {
        Ngo entity = new Ngo();

        entity.setOrganizationName(ngo.getOrganizationName());
        entity.setWebpage(ngo.getWebpage());
        entity.setAddress(ngo.getAddress());
        entity.setStreetNo(ngo.getStreetNo());
        entity.setPostalCode(ngo.getPostalCode());
        entity.setCity(ngo.getCity());
        entity.setCountry(ngo.getCountry());
        entity.setContactPerson(ngo.getContactPerson());
        entity.setDescGreek(ngo.getDescGreek());
        entity.setDescEnglish(ngo.getDescEnglish());
        entity.setSocialMedium1(ngo.getSocialMedium1());
        entity.setSocialMedium2(ngo.getSocialMedium2());
        entity.setSocialMedium3(ngo.getSocialMedium3());
        entity.setLogoId(ngo.getLogoId());
       // entity.setLastOpportunityUpload(Utilities.ft.format(ngo.getLastOpportunityUpload()));
        entity.setUsername(ngo.getUsername());
        entity.setPassword(ngo.getPassword());
        entity.setTelephone(ngo.getTelephone());
        entity.setEmail(ngo.getEmail());
       // entity.setLoggedInLast(Utilities.ft.format(ngo.getLoggedInLast()));
       // entity.setAccountCreated(Utilities.ft.format(ngo.getAccountCreated()));
        return entity;
    }


    /******************************************************************************************************************
     Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static NgoDTO transformNgoEntity2DTO(Ngo ngo) {
        NgoDTO dto = new NgoDTO();
        dto.setOrganizationName(ngo.getOrganizationName());
        dto.setWebpage(ngo.getWebpage());
        dto.setAddress(ngo.getAddress());
        dto.setStreetNo(ngo.getStreetNo());
        dto.setPostalCode(ngo.getPostalCode());
        dto.setCity(ngo.getCity());
        dto.setCountry(ngo.getCountry());
        dto.setContactPerson(ngo.getContactPerson());
        dto.setDescGreek(ngo.getDescGreek());
        dto.setDescEnglish(ngo.getDescEnglish());
        dto.setSocialMedium1(ngo.getSocialMedium1());
        dto.setSocialMedium2(ngo.getSocialMedium2());
        dto.setSocialMedium3(ngo.getSocialMedium3());
        dto.setLogoId(ngo.getLogoId());
        dto.setUsername(ngo.getUsername());
        dto.setPassword(ngo.getPassword());
        dto.setTelephone(ngo.getTelephone());
        dto.setEmail(ngo.getEmail());
        try {
             dto.setLastOpportunityUpload(Utilities.ft.parse(ngo.getLastOpportunityUpload()));
             dto.setLoggedInLast(Utilities.ft.parse(ngo.getLoggedInLast()));
             dto.setAccountCreated(Utilities.ft.parse(ngo.getAccountCreated()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dto;
    }


        /* TODO Check functionality and/or transform to SearchByID.
       public ArrayList<NgoDTO> searchNgo(String organizationName) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        ArrayList<NgoDTO> result = new ArrayList<NgoDTO>();

        String nameparam = organizationName.concat("%");

        Query q = em.createQuery("SELECT n FROM Ngo n WHERE n.organizationName LIKE :organizationName");
        q.setParameter("organizationName", nameparam);
        List<Ngo> ngoList = q.getResultList();
        NgoDTO temp;

        if(ngoList.size() != 0) {
            for (Ngo current : ngoList){
                temp = transformNgoEntity2DTO(current);
                temp.setUserID(current.getUserID());
                result.add(temp);
            }
        }
        em.close();
        factory.close();

        return result;
    } */
}
