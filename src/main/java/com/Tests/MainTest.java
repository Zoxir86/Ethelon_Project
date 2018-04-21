package com.Tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTest {

    public static void main(String args[])
    {
        String PERSISTENCE_UNIT_NAME = "Ethelon";
        EntityManagerFactory factory;
        EntityManager em;

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        em.getTransaction( ).begin( );


       /* QuestionDAO qDao = new QuestionDAOImplementation();
        QuestionnaireDAO qnDao = new QuestionnaireDAOImplementation();

        QuestionDTO questionDTo = new QuestionDTO(0, "English?", "Ελληνικά;");
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
        qnDao.addQuestionToQuestionnaire(questionnaireDTO, questionDTo);

        qDao.insertQuestion(questionDTo);
        qnDao.insertQuestionnaire(questionnaireDTO);
*/

        /*try{
            em.getTransaction().begin();
            Questionnaire entity = em.find( Questionnaire.class, 51 );
            Question q = em.find( Question.class, 1 );
            int h = 0;
        }   catch(Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
            factory.close();
        }*/







        //questionnaireDTO.setDatabaseId(51);

        //qnDao.insertQuestionnaire(questionnaireDTO);

        //qnDao.updateQuestionnaire(questionnaireDTO);

        //String test = Utilities.ProtectPassword("HappyPass");
        //String test2 = Utilities.RevealPassword(test);

//        VolunteerDAO vdao = new VolunteerDAOImplementation();
//
//        // Example 1
//        VolunteerDTO voldto = new VolunteerDTO("Apostolos2", "Thanou", new Date(), true, false, "Kalamata",
//                new Date(), 0, "ap.the.best", "foo", "6940000000", "apostolos@gmail.com",
//                new Date(), new Date());
//
//        //vdao.insertVolunteer(voldto);
//
//
//        // Example 2
//        SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-MM-yyyy");
//        String strdate2 = "02-04-2013";
//        Date newdate = null;
//        try {
//             newdate = dateformat2.parse(strdate2);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        VolunteerDTO voldto2 = new VolunteerDTO("Foteini", "Papadimitriou", newdate, false,
//                false, "Grevena", newdate, 0,  "foto.love", "1234",
//                "6971212120", "nana@yahoo.com", newdate, newdate);
//
//        //vdao.insertVolunteer(voldto2);
//
//        // Example 3f
//        VolunteerDTO voldto3 = new VolunteerDTO("Foteini", "Papadimitriou", newdate, false,
//                false, "Grevena", newdate, 51,  "foto.love", "1234",
//                "6971212120", "nana@yahoo.com", newdate, newdate);
//        //vdao.deleteVolunteer(voldto3);
//
//
//        VolunteerDTO voldto4 = new VolunteerDTO("Apostolos", "Thanou", newdate, true, false, "Naoussa",
//                new Date(), 1, "ap.the.best", "foo", "6940000000", "apostolos@hotmail.com",
//                new Date(), new Date());
//
//        //vdao.updateVolunteer(voldto4);
//
//        NgoDAO ndao = new NgoDAOImplementation();
//
//        NgoDTO ng1 = new NgoDTO("RandomNgo", "http://www.in.gr", "NicePlace", "15", "15424",
//                "Limnoupoli", "Banania", "Boubis", "Καλή εταιρία", "Nice to work there", null, null, null,
//                "logo.jpg", new Date(), 1, "my.nice.uname", "my.nice_pass", "2105555555", "company@peace.cy",
//                newdate, new Date());

        //ndao.insertNgo(ng1);
        //ndao.updateNgo(ng1);
        //ndao.deleteNgo(ng1);
    }

}
