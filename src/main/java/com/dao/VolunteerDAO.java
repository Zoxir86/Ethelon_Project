package com.dao;

import com.database.Volunteer;
import com.dto.VolunteerDTO;

public interface VolunteerDAO {

    // Inserting a new Volunteer entity in the database. Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
    public boolean insertVolunteer(VolunteerDTO dto);

    // Deleting an existing Volunteer entity in the database. Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
    public boolean deleteVolunteer(VolunteerDTO dto);

    // Updating an existing Volunteer entity in the database. Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
    public boolean updateVolunteer(VolunteerDTO dto);

    // Returning a Volunteer entity as persisted in the database when the databaseID is known.
    public Volunteer findVolunteerById(int databaseID);
}
