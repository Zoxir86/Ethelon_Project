package com.Tests;

import com.dao.AreaDAOImplementation;
import com.dto.AreaDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class AreaTest {

    public static void main(String args[]) {

        String PERSISTENCE_UNIT_NAME = "Ethelon";
        EntityManagerFactory factory;
        EntityManager em;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        AreaDAOImplementation daoImp = new AreaDAOImplementation();

        // 1: Inserting all areas into the table.
        /*ArrayList<Area> list = Utilities.getListOfAllAreas();
        em.getTransaction().begin();
        for (Area area : list) {
            em.persist(area);
        }
        em.getTransaction().commit();*/

        // 2: Returning the area corresponding to a particular Postal Code.
        AreaDTO area1 = daoImp.getAreaRelatedToAPostalCode("181 21");

        // 3: Returning a list of Areas whose postal code starts with some digits.
        ArrayList<AreaDTO> areaList1 = daoImp.getAreasWhosePostalCodeStartsWith("18 1");

        // 4: Returning a list of Areas whose description starts with a combination of some characters.
        ArrayList<AreaDTO> areaList2 = daoImp.getListOfAreasStartingWith("ΚΗΦ ");

        // 5: Returning a list of Areas whose description starts contains a combination of some characters.
        ArrayList<AreaDTO> areaList3 = daoImp.getListOfAreasContaining("ΒΑ");

        // 6: Returning a list of Areas who belong to a particular prefecture.
        ArrayList<AreaDTO> areaList4 = daoImp.getListOfAreasOfPrefecture("ΑΡΓΟΛΙΔΟΣ");

        // 7: Returning a list of Areas who belong to a particular country.
        ArrayList<AreaDTO> areaList5 = daoImp.getListOfAreasOfCountry("ΕΛΛΑΔΑ");

        // 8: Returning the full list of Areas.
        ArrayList<AreaDTO> areaList6 = daoImp.getFullListOfAreas();

        // 9:  Returning a list of prefectures who belong to a particular country. Unique values in alphabetical order.
        ArrayList<String> stringList1 = daoImp.getListOfPrefecturesOfCountry("ΕΛΛΑΔΑ");

        // 10: Returning a full list of prefectures. Unique values in alphabetical order. Returns null if nothing is found.
        ArrayList<String> stringList2 = daoImp.getFullListOfPrefectures();

        // 11: Returning a full list of countries. Unique values in alphabetical order. Returns null if nothing is found.
        ArrayList<String> stringList3 = daoImp.getFullListOfCountries();

        em.close();
        factory.close();

    }
}



