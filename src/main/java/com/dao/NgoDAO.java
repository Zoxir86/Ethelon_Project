package com.dao;

import com.dto.NgoDTO;
import com.dto.VolunteerDTO;

import java.util.ArrayList;
import java.util.Date;

public interface NgoDAO {

    // Inserting a new Ngo entity in the database. Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
    public boolean insertNgo(NgoDTO dto);

    // Deleting an existing Ngo entity in the database. Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
    public boolean deleteNgo(NgoDTO dto);

    // Updating an existing Ngo entity in the database. Uses a DTO as input. Returns SUCCESS (true) or ERROR (false).
    public boolean updateNgo(NgoDTO dto);

    //  Updates an existing Ngo entity in the database to mark it as Hidden (from the volunteers). Returns SUCCESS (true) or ERROR (false).
    public boolean markNgoAsHidden(NgoDTO dto);

    // Updates an existing Ngo entity in the database to mark it as NotHidden (from the volunteers). Returns SUCCESS (true) or ERROR (false).
    public boolean markNgoAsNotHidden(NgoDTO dto);

    // Updates an existing Ngo entity in the database to mark it as Approved + Not Hidden (by Ethelon admin). Returns SUCCESS (true) or ERROR (false).
    public boolean markNgoAsApproved(NgoDTO dto);

    // Updates an existing Ngo entity in the database to mark it as Disapproved + Hidden (by Ethelon admin). Returns SUCCESS (true) or ERROR (false).
    public boolean markNgoAsDisapproved(NgoDTO dto);

    // Returns the full list of Ngos. Returns null if nothing is found.
    public ArrayList<NgoDTO> getFullListOfNgos();

    // Returns the full list of Ngos that have not uploaded opportunities after a given date. Returns null if nothing is found.
    public ArrayList<NgoDTO> getFullListOfInactiveNgos(Date date);

    public NgoDTO validateNgo(String username, String password);
}
