package com.dao;

import com.database.Question;
import com.database.Questionnaire;
import com.dto.QuestionDTO;
import com.dto.QuestionnaireDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionnaireDAOImplementation implements QuestionnaireDAO {

    private static final boolean SUCCESS = true;
    private static final boolean ERROR = false;

    private static final String PERSISTENCE_UNIT_NAME = "Ethelon";


    public QuestionnaireDAOImplementation() {
        super();
    }


    //*****************************************************************************************************************
    //*************************************************** INSERTIONS **************************************************
    //*****************************************************************************************************************

    /********************************************************************************************************************
     Inserts a new Question entity in the database.
     *******************************************************************************************************************/

    public boolean insertQuestion(Question entity) {

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
     Inserts a new Questionnaire entity in the database. Uses a DTO as input.
     *******************************************************************************************************************/

    public boolean insertQuestionnaire(QuestionnaireDTO questionnaire) {

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Questionnaire entity = transformQuestionnaireDTO2Entity(questionnaire);
            entity.setInsertDate(Utilities.ft.format(new Date()));
            entity.setUpdateDate(Utilities.ft.format(new Date()));

            for (Question question : entity.getQuestionList()) {
                insertQuestion(question);
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
     Deletes an existing Question entity in the database. Uses a DTO as input.
     *******************************************************************************************************************/

    public boolean deleteQuestion(Question question) {

        if(question.getQuestionId() == 0) return false;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Question entity = em.find( Question.class, question.getQuestionId() );
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
     Deletes an existing Questionnaire entity in the database. Uses a DTO as input.
     *******************************************************************************************************************/

    public boolean deleteQuestionnaire(QuestionnaireDTO questionnaire) {

        if(questionnaire.getDatabaseId() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Questionnaire entity = transformQuestionnaireDTO2Entity(questionnaire);

            for (Question question : entity.getQuestionList()) {
                deleteQuestion(question);
            }

            em.remove(em.find( Questionnaire.class, questionnaire.getDatabaseId() ));
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
     Updates an existing Question entity in the database. Uses a DTO as input.
     *******************************************************************************************************************/

    /*public boolean updateQuestion(Question question) {

        if(question.getQuestionId() == 0) return false;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            Question entity = em.find( Question.class, question.getQuestionId() );
            entity.setUpdateDate(Utilities.ft.format(new Date()));
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
    }*/

    /********************************************************************************************************************
     Updates an existing Questionnaire entity in the database. Uses a DTO as input. It also manages transactions so as to
     permit rollback on failures.
     *******************************************************************************************************************/

    public boolean updateQuestionnaire(QuestionnaireDTO questionnaire) {

        if(questionnaire.getDatabaseId() == 0) return ERROR;

        boolean result;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();

            Questionnaire existingEntity = em.find(Questionnaire.class, questionnaire.getDatabaseId());

            for (Question question : existingEntity.getQuestionList()) {   // Deleting old list questions.
                 deleteQuestion(question);
            }

            Questionnaire entity = transformQuestionnaireDTO2Entity(questionnaire);

            List<Question> list = entity.getQuestionList();

            for (Question question : list) {                              // Assume all questions are new.
                insertQuestion(question);
            }

            existingEntity.setQuestionList(list);
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

    public static QuestionDTO transformQuestionEntity2DTO(Question entity)
    {
        QuestionDTO dto = new QuestionDTO();
        dto.setDatabaseId(entity.getQuestionId());
        dto.setPosition(entity.getPosition());
        dto.setTextEnglish(entity.getTextEnglish());
        dto.setTextGreek(entity.getTextGreek());
        return dto;
    }


    /******************************************************************************************************************
     Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).
     *****************************************************************************************************************/

    public static Question transformQuestionDTO2Entity(QuestionDTO dto)
    {
        Question entity = new Question();
        entity.setQuestionId(dto.getDatabaseId());
        entity.setPosition(dto.getPosition());
        entity.setTextEnglish(dto.getTextEnglish());
        entity.setTextGreek(dto.getTextGreek());
        return entity;
    }


    /******************************************************************************************************************
     Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static List<QuestionDTO> transformQuestionListEntity2DTO(List<Question> entityList)
    {
        List<QuestionDTO> dtoList = new ArrayList<QuestionDTO>();
        for (Question entityQuestion : entityList) {
            dtoList.add(transformQuestionEntity2DTO(entityQuestion));
        }
        return dtoList;
    }


    /******************************************************************************************************************
     Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).
     *****************************************************************************************************************/

    public static List<Question> transformQuestionListDTO2Entity(List<QuestionDTO> dtoList)
    {
        List<Question> entityList = new ArrayList<Question>();
        for (QuestionDTO dtoQuestion : dtoList) {
            entityList.add(transformQuestionDTO2Entity(dtoQuestion));
        }
        return entityList;
    }


    /******************************************************************************************************************
     Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static QuestionnaireDTO transformQuestionnaireEntity2DTO(Questionnaire entity) {

        QuestionnaireDTO dto = new QuestionnaireDTO();
        dto.setDatabaseId(entity.getQuestionnaireId());
        List<QuestionDTO> dtoList = transformQuestionListEntity2DTO(entity.getQuestionList());
        dto.setQuestionList(dtoList);
        return dto;
    }


    /******************************************************************************************************************
     Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).
     *****************************************************************************************************************/

    public static Questionnaire transformQuestionnaireDTO2Entity(QuestionnaireDTO dto) {

        Questionnaire entity = new Questionnaire();
        entity.setQuestionnaireId(dto.getDatabaseId());
        List<Question> entityList = transformQuestionListDTO2Entity(dto.getQuestionList());
        entity.setQuestionList(entityList);
        return entity;
    }


    /******************************************************************************************************************
     Utility: Returns a Questionnaire entity as persisted in the database when the databaseID is known.
     *****************************************************************************************************************/

    public static Questionnaire findQuestionnaireById(int databaseID)
    {
        if(databaseID == 0) return null;

        Questionnaire entity;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            entity = em.find( Questionnaire.class, databaseID );
        } catch(Exception e) {
            entity = null;
        }
        finally {
            em.close();
            factory.close();
        }

        return entity;
    }

} // End of QuestionnaireDAOImplementation class.
