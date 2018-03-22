package com.dao;

import com.dto.VolunteerDTO;

import java.util.ArrayList;
import java.util.Date;

public interface VolunteerDAO {

    //public boolean logInVolunteer(String username, String password); //TODO we might actually not be doing this in the Model
    public boolean insertVolunteer(VolunteerDTO volunteer);
    public boolean deleteVolunteer(VolunteerDTO volunteer);
    public boolean updateVolunteer(VolunteerDTO volunteer);
    //public ArrayList<VolunteerDTO> searchVolunteer(String name, String surname, Date dateOfBirth); //TODO we actually need a return by id
}
