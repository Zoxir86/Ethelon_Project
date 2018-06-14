package com.Tests;

import com.dao.VolunteerDAOImplementation;
import com.database.Sex;
import com.dto.AreaDTO;
import com.dto.InterestDTO;
import com.dto.VolunteerDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VolunteerTest {

    public static void main(String args[]) {

        AreaDTO areadto = new AreaDTO(609, null, null, null, null);
        InterestDTO interestdto = new InterestDTO(1357, null, null,
                null, null);
        List<InterestDTO> interestlist = new ArrayList<InterestDTO>();
        interestlist.add(interestdto);

        VolunteerDAOImplementation daoImp = new VolunteerDAOImplementation();

        VolunteerDTO vdto = new VolunteerDTO("Panagiotis", "Spyropoulos", new Date(),
                Sex.FEMALE, false, false, null, areadto,
                null, null, interestlist, null,
                "", 0, "melpo", "1234", "6944444444",
                "melpo@yahoo.com", null, null, null);
        daoImp.insertVolunteer(vdto);

        vdto.setDatabaseID(1);
        //daoImp.deleteVolunteer(vdto);

        // Updating a Volunteer.
        //vdto.setDatabaseID(51);
        //vdto.setName("Aspasia");
        //daoImp.updateVolunteer(vdto);
    }
}
