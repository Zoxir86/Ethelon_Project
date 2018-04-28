package com.Tests;

import com.dao.VolunteerDAOImplementation;
import com.database.Sex;
import com.dto.VolunteerDTO;

import java.util.Date;

public class VolunteerTest {

    public static void main(String args[]) {

        VolunteerDAOImplementation daoImp = new VolunteerDAOImplementation();

        // Inserting a new Volunteer entity in the database. Uses a DTO as input. Returns SUCCESS (true) or  ERROR (false).
        VolunteerDTO vdto = new VolunteerDTO("Melpomeni", "Stassinou", new Date(), Sex.FEMALE, false, false, null, null,
                null, null, null, null, "", 0, "melpo", "1234", "6944444444",
                "melpo@yahoo.com", null, null, null);
        daoImp.insertVolunteer(vdto);

        // Deleting said Volunteer (magically we know id = 1)
        vdto.setDatabaseID(1);
        daoImp.deleteVolunteer(vdto);

        // Updating a Volunteer.
        vdto.setDatabaseID(51);
        vdto.setName("Aspasia");
        daoImp.updateVolunteer(vdto);
    }
}
