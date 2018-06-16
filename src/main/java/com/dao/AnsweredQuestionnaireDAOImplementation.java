package com.dao;

import com.database.Answer;
import com.database.AnsweredQuestionnaire;
import com.dto.AnswerDTO;
import com.dto.AnsweredQuestionnaireDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnsweredQuestionnaireDAOImplementation implements AnsweredQuestionnaireDAO {

    private static final boolean SUCCESS = true;
    private static final boolean ERROR = false;

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";


    public AnsweredQuestionnaireDAOImplementation() {
        super();
    }


    //*****************************************************************************************************************
    //*************************************************** INSERTIONS **************************************************
    //*****************************************************************************************************************

    /********************************************************************************************************************
     Inserts a new Answer entity in the database.
     *******************************************************************************************************************/

    private boolean insertAnswer(Answer entity) {

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
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
     Inserts a new AnsweredQuestionnaire entity in the database. Uses a DTO as input.
     *******************************************************************************************************************/

    public boolean insertAnsweredQuestionnaire(AnsweredQuestionnaireDTO dto) {

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            AnsweredQuestionnaire entity = transformAnsweredQuestionnaireDTO2Entity(dto);
            entity.setInsertDate(Utilities.ft.format(new Date()));
            entity.setUpdateDate(Utilities.ft.format(new Date()));

            for (Answer answer : entity.getAnswersList()) {
                insertAnswer(answer);
            }

            em.persist(entity);
            em.getTransaction().commit();
            result = true;
        } catch(Exception e) {
            em.getTransaction().rollback();
            result = false;
        }
        finally {
            if(em.isOpen()) em.close();
            factory.close();
        }

        return result;
    }


    //*****************************************************************************************************************
    //*************************************************** DELETIONS ***************************************************
    //*****************************************************************************************************************

    /********************************************************************************************************************
     Deletes an existing Answer entity in the database. Uses a DTO as input.
     *******************************************************************************************************************/

    private boolean deleteAnswer(Answer answer) {

        if(answer.getAnswerId() == 0) return false;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Answer entity = em.find( Answer.class, answer.getAnswerId() );
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
     Deletes an existing AnsweredQuestionnaire entity in the database. Uses a DTO as input.
     *******************************************************************************************************************/

    public boolean deleteAnsweredQuestionnaire(AnsweredQuestionnaireDTO dto) {

        if(dto.getDatabaseId() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            AnsweredQuestionnaire entity = transformAnsweredQuestionnaireDTO2Entity(dto);

            for (Answer answer : entity.getAnswersList()) {
                deleteAnswer(answer);
            }

            em.remove(em.find( AnsweredQuestionnaire.class, dto.getDatabaseId() ));
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


    //*****************************************************************************************************************
    //*************************************************** UPDATES  ****************************************************
    //*****************************************************************************************************************


     /********************************************************************************************************************
     Updates an existing AnsweredQuestionnaire entity in the database. Uses a DTO as input. It also manages
      transactions so as to permit rollback on failures.
     *******************************************************************************************************************/

    public boolean updateAnsweredQuestionnaire(AnsweredQuestionnaireDTO dto) {

        if(dto.getDatabaseId() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();

            AnsweredQuestionnaire existingEntity = em.find(AnsweredQuestionnaire.class, dto.getDatabaseId());

            for (Answer answer : existingEntity.getAnswersList()) {   // Deleting old list answers.
                deleteAnswer(answer);
            }

            AnsweredQuestionnaire entity = transformAnsweredQuestionnaireDTO2Entity(dto);

            List<Answer> list = entity.getAnswersList();

            for (Answer answer : list) {                              // Assume all answers are new.
                insertAnswer(answer);
            }

            existingEntity.setAnswersList(list);
            existingEntity.setUpdateDate(Utilities.ft.format(new Date()));

            em.persist(existingEntity);
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


    //*****************************************************************************************************************
    //************************************************* TRANSFORMATIONS ***********************************************
    //*****************************************************************************************************************


    /******************************************************************************************************************
     Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static AnswerDTO transformAnswerEntity2DTO(Answer entity)
    {
        AnswerDTO dto = new AnswerDTO();
        dto.setDatabaseId(entity.getAnswerId());
        dto.setPosition(entity.getPosition());
        dto.setAnswerText(entity.getAnswerText());

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
     Note that insert and update dates are not update in the database this way.
     *****************************************************************************************************************/

    public static Answer transformAnswerDTO2Entity(AnswerDTO dto)
    {
        Answer entity = new Answer();
        entity.setAnswerId(dto.getDatabaseId());
        entity.setPosition(dto.getPosition());
        entity.setAnswerText(dto.getAnswerText());
        return entity;
    }


    /******************************************************************************************************************
     Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static List<AnswerDTO> transformAnswerListEntity2DTO(List<Answer> entityList)
    {
        List<AnswerDTO> dtoList = new ArrayList<AnswerDTO>();
        for (Answer entityAnswer : entityList) {
            dtoList.add(transformAnswerEntity2DTO(entityAnswer));
        }
        return dtoList;
    }


    /******************************************************************************************************************
     Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).
     *****************************************************************************************************************/

    public static List<Answer> transformAnswerListDTO2Entity(List<AnswerDTO> dtoList)
    {
        List<Answer> entityList = new ArrayList<Answer>();
        for (AnswerDTO dtoAnswer : dtoList) {
            entityList.add(transformAnswerDTO2Entity(dtoAnswer));
        }
        return entityList;
    }


    /******************************************************************************************************************
     Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static AnsweredQuestionnaireDTO transformAnsweredQuestionnaireEntity2DTO(AnsweredQuestionnaire entity) {

        AnsweredQuestionnaireDTO dto = new AnsweredQuestionnaireDTO();
        dto.setDatabaseId(entity.getAnsweredQuestionnaireId());
        List<AnswerDTO> dtoList = transformAnswerListEntity2DTO(entity.getAnswersList());
        dto.setAnswersList(dtoList);
        return dto;
    }


    /******************************************************************************************************************
     Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).
     *****************************************************************************************************************/

    public static AnsweredQuestionnaire transformAnsweredQuestionnaireDTO2Entity(AnsweredQuestionnaireDTO dto) {

        AnsweredQuestionnaire entity = new AnsweredQuestionnaire();
        entity.setAnsweredQuestionnaireId(dto.getDatabaseId());
        List<Answer> entityList = transformAnswerListDTO2Entity(dto.getAnswersList());
        entity.setAnswersList(entityList);
        return entity;
    }


    /******************************************************************************************************************
     Utility: Returns an AnsweredQuestionnaire entity as persisted in the database when the databaseID is known.
     *****************************************************************************************************************/

    public static AnsweredQuestionnaire findAnsweredQuestionnaireById(int databaseID)
    {
        if(databaseID == 0) return null;

        AnsweredQuestionnaire entity;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            entity = em.find( AnsweredQuestionnaire.class, databaseID );
        } catch(Exception e) {
            entity = null;
        }
        finally {
            em.close();
            factory.close();
        }

        return entity;
    }

} // End of AnsweredQuestionnaireDAOImplementation class.
