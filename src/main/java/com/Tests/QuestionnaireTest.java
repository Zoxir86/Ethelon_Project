package com.Tests;

import com.dao.QuestionnaireDAOImplementation;
import com.dao.Utilities;
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

public class QuestionnaireTest {

    public static void main(String args[]) {
        String PERSISTENCE_UNIT_NAME = "Ethelon";
        EntityManagerFactory factory;
        EntityManager em;

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        em.getTransaction().begin();


        // Creating a question and adding it to the database.
        Question question = new Question();
        question.setTextEnglish("Hello?");
        question.setTextGreek("Κανείς εκεί έξω;");
        question.setPosition(1);
        question.setInsertDate(Utilities.ft.format(new Date()));
        question.setUpdateDate(Utilities.ft.format(new Date()));
        em.persist(question);

        // Creating a question and adding it to the database.
        Question question2 = new Question();
        question2.setTextEnglish("Are you there?");
        question2.setTextGreek("Κάπου εκεί;");
        question2.setPosition(2);
        question2.setInsertDate(Utilities.ft.format(new Date()));
        question2.setUpdateDate(Utilities.ft.format(new Date()));
        em.persist(question2);

        // Adding the two questions in a list.
        List<Question> qList = new ArrayList();
        qList.add(question);
        qList.add(question2);

        // Creating a new questionnaire and assigning it the list. Then adding it to the database.
        Questionnaire nr = new Questionnaire();
        nr.setQuestionList(qList);
        nr.setInsertDate(Utilities.ft.format(new Date()));
        nr.setUpdateDate(Utilities.ft.format(new Date()));
        em.persist(nr);

        em.getTransaction().commit();

        // Reading the questionnaire (along with the two questions).
        try {
            em.getTransaction().begin();
            //Questionnaire entity = em.find( Questionnaire.class, 3 );
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

        // Creating question DTOs
        QuestionDTO dto1 = new QuestionDTO();
        dto1.setTextEnglish("What time is it?");
        dto1.setTextGreek("Τι ώρα είναι;");

        QuestionDTO dto2 = new QuestionDTO();
        dto2.setTextEnglish("Does it rain a lot?");
        dto2.setTextGreek("Βρέχει πολύ;");

        // Assigning them to a Questionnaire DTO and inserting it into the database
        QuestionnaireDTO dto3 = new QuestionnaireDTO();
        List<QuestionDTO> list = new ArrayList<QuestionDTO>();
        list.add(dto1);
        list.add(dto2);
        dto3.setQuestionList(list);

        QuestionnaireDAOImplementation i = new QuestionnaireDAOImplementation();
        boolean u = i.insertQuestionnaire(dto3);

        // Updating the second questionnaire (we read it first to get updates - those normally come from the front-end).
        Questionnaire uu = new Questionnaire();
        try {
            uu = em.find(Questionnaire.class, 6); // We know this id magically
            List<Question> eeee = uu.getQuestionList();
            StringBuilder b = null;
            for (Question q : eeee) {
                b = new StringBuilder(q.getTextGreek());
                b.append("kkkkk");
                q.setTextGreek(b.toString());
            }
        } catch (Exception e) {
            int j = 0;
        }

        if (uu != null) {
            QuestionnaireDTO dto4 = QuestionnaireDAOImplementation.transformQuestionnaireEntity2DTO(uu);
            boolean j = i.updateQuestionnaire(dto4);
        }

        // Deleting the second questionnaire (we read it first to get updates - those normally come from the front-end).
        Questionnaire mm = new Questionnaire();
        try {
            //em.getTransaction().begin();
            mm = em.find(Questionnaire.class, 6); // We know this id magically
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

        if (mm != null) {
            QuestionnaireDTO dto4 = QuestionnaireDAOImplementation.transformQuestionnaireEntity2DTO(mm);
            boolean j = i.deleteQuestionnaire(dto4);
        }

        em.close();
        factory.close();
    }
}



