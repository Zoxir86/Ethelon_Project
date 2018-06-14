package com.Tests;

import com.dao.InterestDAOImplementation;
import com.dao.OpportunityDAOImplementation;
import com.database.Interest;
import com.dto.InterestDTO;
import com.dto.OpportunityDTO;

import java.util.ArrayList;

public class OpportunityTest {

    public static void main(String args[]) {

        OpportunityDAOImplementation odi = new OpportunityDAOImplementation();
        ArrayList<OpportunityDTO> list = odi.getFullListOfOpportunities();

        InterestDAOImplementation p = new InterestDAOImplementation();
        ArrayList<InterestDTO> a = p.getFullListOfInterests();
        int j = 0;

        /*String PERSISTENCE_UNIT_NAME = "Ethelon";
        EntityManagerFactory factory;
        EntityManager em;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        //AreaDAOImplementation daoImp = new AreaDAOImplementation();

        ArrayList<Interest> list = Utilities.getListOfAllInterests();
        em.getTransaction().begin();
        for (Interest inter : list) {
            em.persist(inter);
        }
        em.getTransaction().commit();*/

        Interest i = InterestDAOImplementation.findInterestById(1352);
        InterestDTO idto = InterestDAOImplementation.transformInterestEntity2DTO(i);

        /*NgoDTO n1 = new NgoDTO("UNICEF", "", "", "", "", "", "", "", "", "", "", "", "", "", null, 0, "", "", "", "", null, null);

        AreaDAOImplementation daoImp = new AreaDAOImplementation();
        AreaDTO area1 = daoImp.getAreaRelatedToAPostalCode("181 21");

        OpportunityDTO op = new OpportunityDTO(0, "Εμβολιασμός Παιδιών Προσφύγων", "",
                "Η UNICEF επιδιώκει τη διασφάλιση των δικαιωμάτων των παιδιών " +
                        "προσφύγων και μεταναστών, και την κάλυψη των άμεσων και των μακροπρόθεσμων αναγκών τους.",
                "", "", "",
                "", "", "http://1.bp.blogspot.com/-o9GemIysU5c/U3DQG4ZJuOI/AAAAAAAAFUo/jRJIKEiEs9g/s1600/unicef.jpg",
                null, null, null, null, false, false, true, false,
                null, null, null, null, null, n1, area1, idto, null);

        OpportunityDAOImplementation kkk = new OpportunityDAOImplementation();
        boolean ll = kkk.insertOpportunity(op);

        int k = 0;*/
    }
}
