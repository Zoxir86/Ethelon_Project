package com.controller;

import com.dao.AdminDAO;
import com.dao.AdminDAOImplementation;
import com.database.Volunteer;
import com.dto.VolunteerDTO;
import com.services.Email;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "AdminController")
@SessionScoped
public class AdminController {

    /**
     * A list of all the platform volunteers.
     */
    private List<VolunteerDTO> volunteersList;

    private AdminDAO adminDao = new AdminDAOImplementation();

    private Boolean submitted = false;

    public String sendEmails() {
        try {
            Email.send(getEmailList());
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
        return "dashboard.xhtml";
    }

    public List<VolunteerDTO> getVolunteersList() {
        volunteersList = new ArrayList<VolunteerDTO>();
        List<Volunteer> allVolunteers = adminDao.getAllVolunteers();
        allVolunteers.forEach(volunteer -> {
            VolunteerDTO temp = new VolunteerDTO();
            temp.setName(volunteer.getName());
            temp.setSurname(volunteer.getSurname());
            temp.setEmail(volunteer.getEmail());
            volunteersList.add(temp);
        });
        return volunteersList;
    }

    public void setVolunteersList(List<VolunteerDTO> list) {
        volunteersList = list;
    }

    private String[] getEmailList() {
        List<String> selectedEmails = new ArrayList<String>();
        volunteersList.forEach(volunteerDTO -> {
            if (volunteerDTO.isSelected()) {
                selectedEmails.add(volunteerDTO.getEmail());
            }
        });
        String[] emails = new String[selectedEmails.size()];
        return selectedEmails.toArray(emails);
    }

    public Boolean getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Boolean value) {
        this.submitted = value;
    }
}
