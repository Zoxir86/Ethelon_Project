package com.Tests;

import com.dao.ApplicationDAOImplementation;
import com.dao.VolunteerDAOImplementation;
import com.database.Application;
import com.database.Opportunity;
import com.database.Question;
import com.dto.ApplicationDTO;
import com.dto.OpportunityDTO;
import com.dto.VolunteerDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpportApplicTest {

    public static void main(String args[]) {
        String PERSISTENCE_UNIT_NAME = "Ethelon";
        EntityManagerFactory factory;
        EntityManager em;
        ApplicationDAOImplementation apdaoim = new ApplicationDAOImplementation();

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();


        // 1: Creating an application and associating it with an opportunity and a volunteer.
        em.getTransaction().begin();

        VolunteerDTO voldto = new VolunteerDTO("Apostolos2", "Thanou", new Date(), true, false, "Kalamata",
                new Date(), 0, "ap.the.best", "foo", "6940000000", "apostolos@gmail.com",
                new Date(), new Date());
        voldto.setDatabaseID(1);  // Normally we do not set this, but in the example we want to avoid searching.
        VolunteerDAOImplementation vi = new VolunteerDAOImplementation();
        vi.insertVolunteer(voldto);

        Opportunity opportunity = new Opportunity();
        em.persist(opportunity);
        em.getTransaction().commit();

        OpportunityDTO oppDTO = new OpportunityDTO();
        oppDTO.setDatabaseId(2);         // Normally we do not set this, but in the example we want to avoid searching.

        ApplicationDTO appDTO = new ApplicationDTO();
        appDTO.setAvailability("Weekends, twice a month.");
        appDTO.setCvIdentifier("Foufoutos.pdf");
        appDTO.setComments("Experienced working with children with disabilities.");
        apdaoim.insertApplicationForOpportunity(appDTO, oppDTO, voldto);

        // 2: Then return the opportunity related to an application.
        appDTO.setDatabaseId(3);         // Normally we do not set this, but in the example we want to avoid searching.
        OpportunityDTO oppDTO2 = apdaoim.getRelatedOpportunityOfApplication(appDTO);

        // 3: Then mark the application as "Disapproved".
        apdaoim.markApplicationAsDisapproved(appDTO);
        apdaoim.markApplicationAsCancelledByAdministrator(appDTO);

        em.close();
        factory.close();

    }
}
