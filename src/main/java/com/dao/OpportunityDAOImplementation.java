package com.dao;

import com.database.*;
import com.dto.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.dao.InterestDAOImplementation.transformInterestEntity2DTO;

public class OpportunityDAOImplementation implements OpportunityDAO {

    private static final boolean SUCCESS = true;
    private static final boolean ERROR = false;

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";


    /********************************************************************************************************************
     Inserts a new Opportunity entity in the database. Associates the Opportunity with an already existing NGO.
     Uses DTOs as input.
     *******************************************************************************************************************/

    public boolean insertOpportunity(OpportunityDTO dto)
    {
        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();

            // Persisting opportunity.
            Opportunity opportunity = transformOpportunityDTO2Entity(dto);
            opportunity.setAddDate(Utilities.ft.format(new Date()));
            opportunity.setUpdateDate(Utilities.ft.format(new Date()));
            opportunity.setHiddenYN(false);
            em.persist(opportunity);

            // Updating list of opportunities for the related Ngo.
            if(opportunity.getNgo() != null) {
                Ngo ngo = em.find(Ngo.class, opportunity.getNgo().getUserID());
                List<Opportunity> list = ngo.getOpportunitiesList();
                list.add(opportunity);
                ngo.setOpportunitiesList(list);
                ngo.setLastOpportunityUpload(Utilities.ft.format(new Date()));
                em.persist(opportunity);
            }

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
     Returns the full list of Opportunities. Returns null if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<OpportunityDTO> getFullListOfOpportunities()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<OpportunityDTO> opportunityDTOList = new ArrayList<OpportunityDTO>();

        try {
            Query q = em.createQuery("SELECT o FROM Opportunity o ");
            List<Opportunity> opportunitiesList = q.getResultList();
            OpportunityDTO temp;

            if (opportunitiesList.size() != 0) {
                for (Opportunity current : opportunitiesList) {
                    temp = transformOpportunityEntity2DTO(current);
                    temp.setDatabaseID(current.getOpportunityID());
                    opportunityDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            opportunityDTOList = null;
        } finally {
            em.close();
            factory.close();
        }

        return opportunityDTOList;
    }

    public ArrayList<OpportunityDTO> getListOfNgoOpportunities(int ngoID)
    {
        if(ngoID == 0) return null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<OpportunityDTO> opportunityNgoDTOList = new ArrayList<OpportunityDTO>();

        try {
            Query q = em.createQuery("SELECT o FROM Opportunity o WHERE o.ngo.userID= :ngoID ");
            q.setParameter("ngoID", ngoID);
            List<Opportunity> opportunitiesList = q.getResultList();
            OpportunityDTO temp;

            if (opportunitiesList.size() != 0) {
                for (Opportunity current : opportunitiesList) {
                    temp = transformOpportunityEntity2DTO(current);
                    temp.setDatabaseID(current.getOpportunityID());
                    opportunityNgoDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            opportunityNgoDTOList = null;
        } finally {
            em.close();
            factory.close();
        }

        return opportunityNgoDTOList;
    }


    /********************************************************************************************************************
     Returns a list of the Opportunities that are open and not hidden. Also checks whether the respective Ngo is
     approved and not hidden. Returns null if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<OpportunityDTO> getListOfOpenNotHiddenOpportunities()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<OpportunityDTO> opportunityDTOList = new ArrayList<OpportunityDTO>();

        try {
            Query q = em.createQuery("SELECT o FROM Opportunity o WHERE o.isHiddenYN = false AND o.isOpenYN = true ");
            List<Opportunity> opportunitiesList = q.getResultList();
            OpportunityDTO temp;
            Ngo ngo;

            if (opportunitiesList.size() != 0) {
                for (Opportunity current : opportunitiesList) {

                    ngo = current.getNgo();
                    if(ngo == null) continue;   // This state is obviously erroneous.
                    if(ngo.isHiddenYN() == true || ngo.getStatus() != ApplicationState.APPROVED) continue;

                    temp = transformOpportunityEntity2DTO(current);
                    temp.setDatabaseID(current.getOpportunityID());
                    opportunityDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            opportunityDTOList = null;
        } finally {
            em.close();
            factory.close();
        }

        return opportunityDTOList;
    }


    /********************************************************************************************************************
     Returns a list of the Opportunities that are open and not hidden for a particular Ngo. Also checks whether
     the Ngo is approved and not hidden. Returns null if nothing is found.
     *******************************************************************************************************************/

    public ArrayList<OpportunityDTO> getListOfOpenNotHiddenOpportunitiesForParticularNgo(NgoDTO organization)
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        ArrayList<OpportunityDTO> opportunityDTOList = new ArrayList<OpportunityDTO>();

        try {
            Query q = em.createQuery("SELECT o FROM Opportunity o WHERE o.isHiddenYN = false AND o.isOpenYN = true ");
            List<Opportunity> opportunitiesList = q.getResultList();
            OpportunityDTO temp;
            Ngo ngo;

            if (opportunitiesList.size() != 0) {
                for (Opportunity current : opportunitiesList) {

                    ngo = current.getNgo();
                    if(ngo == null) continue;   // This state is obviously erroneous.
                    if(ngo.getUserID() != organization.getDatabaseID()) continue;
                    if(ngo.isHiddenYN() == true || ngo.getStatus() != ApplicationState.APPROVED) continue;

                    temp = transformOpportunityEntity2DTO(current);
                    temp.setDatabaseID(current.getOpportunityID());
                    opportunityDTOList.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            opportunityDTOList = null;
        } finally {
            em.close();
            factory.close();
        }

        return opportunityDTOList;
    }


    /********************************************************************************************************************
     Marks an opportunity as Hidden from the frontend.
     *******************************************************************************************************************/

    public boolean markOpportunityAsHidden(OpportunityDTO dto){

        if(dto.getDatabaseID() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try{
            em.getTransaction().begin();
            Opportunity entity = em.find( Opportunity.class, dto.getDatabaseID());
            entity.setHiddenYN(true);
            entity.setUpdateDate(Utilities.ft.format(new Date()));
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
     Closes an opportunity so applications may no longer be submitted.
     *******************************************************************************************************************/

    public boolean markOpportunityAsClosed(OpportunityDTO dto){

        if(dto.getDatabaseID() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try{
            em.getTransaction().begin();
            Opportunity entity = em.find( Opportunity.class, dto.getDatabaseID());
            entity.setOpenYN(false);
            entity.setCloseDate(Utilities.ft.format(new Date()));
            entity.setUpdateDate(Utilities.ft.format(new Date()));
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


    /******************************************************************************************************************
     Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static OpportunityDTO transformOpportunityEntity2DTO(Opportunity entity)
    {
        OpportunityDTO dto = new OpportunityDTO();
        dto.setDatabaseID(entity.getOpportunityID());
        dto.setGreekTitle(entity.getGreekTitle());
        dto.setEnglishTitle(entity.getEnglishTitle());
        dto.setGreekSummary(entity.getGreekSummary());
        dto.setEnglishSummary(entity.getEnglishSummary());
        dto.setGreekDescription(entity.getGreekDescription());
        dto.setEnglishDescription(entity.getEnglishDescription());
        dto.setContactPerson(entity.getContactPerson());
        dto.setContactPersonEmail(entity.getContactPersonEmail());
        dto.setImagePath(entity.getImagePath());

        try {
            if(entity.getAddDate() != null) dto.setAddDate(Utilities.ft.parse(entity.getAddDate()));
            if(entity.getUpdateDate() != null) dto.setUpdateDate(Utilities.ft.parse(entity.getUpdateDate()));
            if(entity.getOpenDate() != null) dto.setOpenDate(Utilities.ft.parse(entity.getOpenDate()));
            if(entity.getCloseDate() != null) dto.setCloseDate(Utilities.ft.parse(entity.getCloseDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dto.setTrainingProvidedYN(entity.isTrainingProvidedYN());
        dto.setHiddenYN(entity.isHiddenYN());
        dto.setOpenYN(entity.isOpenYN());
        dto.setEthelonYN(entity.isEthelonYN());

        dto.setApplicationsList(new ArrayList<ApplicationDTO>());
        if(dto.getApplicationsList() != null && !entity.getApplicationsList().isEmpty())
        {
            for (Application temp : entity.getApplicationsList()) {
                dto.getApplicationsList().add(ApplicationDAOImplementation.transformApplicationEntity2DTO(temp));
            }
        }

        dto.setKnowledgeAreasList(new ArrayList<KnowledgeAreaDTO>());
        if(dto.getKnowledgeAreasList() != null && !entity.getKnowledgeAreasList().isEmpty())
        {
            for (KnowledgeArea temp : entity.getKnowledgeAreasList()) {
                dto.getKnowledgeAreasList().add(KnowledgeAreaDAOImplementation.transformKnowledgeAreaEntity2DTO(temp));
            }
        }

        dto.setSecondaryCategoriesList(new ArrayList<InterestDTO>());
        if(dto.getSecondaryCategoriesList() != null && !entity.getSecondaryCategoriesList().isEmpty())
        {
            for (Interest temp : entity.getSecondaryCategoriesList()) {
                dto.getSecondaryCategoriesList().add(transformInterestEntity2DTO(temp));
            }
        }

        if(entity.getNgo() != null) dto.setNgo(NgoDAOImplementation.transformNgoEntity2DTO(entity.getNgo()));
        if(entity.getArea() != null) dto.setArea(AreaDAOImplementation.transformAreaEntity2DTO(entity.getArea()));
        if(entity.getPrimarycategory() != null) dto.setPrimarycategory(transformInterestEntity2DTO(entity.getPrimarycategory()));
        if(entity.getQuestionnaire() != null) dto.setQuestionnaire(QuestionnaireDAOImplementation.transformQuestionnaireEntity2DTO(entity.getQuestionnaire()));

        return dto;
    }


    /******************************************************************************************************************
     Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).

     Note: addDate, updateDate are never transported through a DTO towards the database.
     Applications/SecondaryCategories/KnowledgeAreas entities are provided by the database, only the ID
     is used from the DTO.
     *****************************************************************************************************************/

    public static Opportunity transformOpportunityDTO2Entity(OpportunityDTO dto)
    {
        Opportunity entity = new Opportunity();
        entity.setOpportunityID(dto.getDatabaseID());
        entity.setGreekTitle(dto.getGreekTitle());
        entity.setEnglishTitle(dto.getEnglishTitle());
        entity.setGreekSummary(dto.getGreekSummary());
        entity.setEnglishSummary(dto.getEnglishSummary());
        entity.setGreekDescription(dto.getGreekDescription());
        entity.setEnglishDescription(dto.getEnglishDescription());
        entity.setContactPerson(dto.getContactPerson());
        entity.setContactPersonEmail(dto.getContactPersonEmail());
        entity.setImagePath(dto.getImagePath());
        if(dto.getOpenDate() != null) entity.setOpenDate(Utilities.ft.format(dto.getOpenDate()));
        if(dto.getCloseDate() != null) entity.setCloseDate(Utilities.ft.format(dto.getCloseDate()));
        entity.setTrainingProvidedYN(dto.isTrainingProvidedYN());
        entity.setHiddenYN(dto.isHiddenYN());
        entity.setOpenYN(dto.isOpenYN());
        entity.setEthelonYN(dto.isEthelonYN());

        entity.setApplicationsList(new ArrayList<Application>());
        if(dto.getApplicationsList() != null && !dto.getApplicationsList().isEmpty())
        {
            for (ApplicationDTO temp : dto.getApplicationsList()) {
                entity.getApplicationsList().add(ApplicationDAOImplementation.findApplicationById(temp.getDatabaseId()));
            }
        }

        entity.setSecondaryCategoriesList(new ArrayList<Interest>());
        if(dto.getSecondaryCategoriesList() != null && !dto.getSecondaryCategoriesList().isEmpty())
        {
            for (InterestDTO temp : dto.getSecondaryCategoriesList()) {
                entity.getSecondaryCategoriesList().add(InterestDAOImplementation.findInterestById(temp.getDatabaseID()));
            }
        }

        entity.setKnowledgeAreasList(new ArrayList<KnowledgeArea>());
        if(dto.getKnowledgeAreasList() != null && !dto.getKnowledgeAreasList().isEmpty())
        {
            for (KnowledgeAreaDTO temp : dto.getKnowledgeAreasList()) {
                entity.getKnowledgeAreasList().add(KnowledgeAreaDAOImplementation.findKnowledgeAreaById(temp.getDatabaseID()));
            }
        }

        if(dto.getNgo() != null) entity.setNgo(NgoDAOImplementation.findNgoById(dto.getNgo().getDatabaseID()));
        if(dto.getArea() != null) entity.setArea(AreaDAOImplementation.findAreaById(dto.getArea().getDatabaseID()));
        if(dto.getPrimarycategory() != null) entity.setPrimarycategory(InterestDAOImplementation.findInterestById(dto.getPrimarycategory().getDatabaseID()));
        if(dto.getQuestionnaire() != null) entity.setQuestionnaire(QuestionnaireDAOImplementation.findQuestionnaireById(dto.getQuestionnaire().getDatabaseId()));

        return entity;
    }


    /******************************************************************************************************************
     Utility: Returns an Opportunity entity as persisted in the database when the databaseID is known.
     *****************************************************************************************************************/

    public static Opportunity findOpportunityById(int databaseID)
    {
        if(databaseID == 0) return null;

        Opportunity entity;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            entity = em.find( Opportunity.class, databaseID );
        } catch(Exception e) {
            entity = null;
        }
        finally {
            em.close();
            factory.close();
        }

        return entity;
    }

    public OpportunityDTO checkOpportunity (int databaseID){
        if(databaseID == 0) return  null;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Opportunity entity;
        OpportunityDTO opportunityDTO;

        try {
            Query query= em.createQuery("SELECT o FROM Opportunity o WHERE o.opportunityID = :opportunityID ");
            query.setParameter("opportunityID", databaseID);
            entity = (Opportunity) query.getSingleResult();
            opportunityDTO=transformOpportunityEntity2DTO(entity);


        } catch(Exception e) {
            opportunityDTO=null;
        }


        finally {
            em.close();
            factory.close();
        }

        return opportunityDTO;
    }
} // End of OpportunityDAOImplementation class.
