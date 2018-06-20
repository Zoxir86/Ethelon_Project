package com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.dao.*;
import com.database.AnsweredQuestionnaire;
import com.database.Application;
import com.database.Opportunity;
import com.dto.*;


@ManagedBean (name = "aplcontr")
@SessionScoped
public class ApplicationController implements Serializable{

    private ApplicationDAO applicationDao = new ApplicationDAOImplementation();
    private ApplicationDTO applicationDto = new ApplicationDTO();
    private OpportunityDTO opportunityDto = new OpportunityDTO();
    private AnsweredQuestionnaireDTO answeredQuestionnaireDTO = new AnsweredQuestionnaireDTO();
    private VolunteerDTO volunteerDto = new VolunteerDTO();
    private List<ApplicationDTO> applist = new ArrayList<ApplicationDTO>();

    public ApplicationDTO getApplicationDto() {
        return applicationDto;
    }

    public String setApplicationDto() {   /* Not finished */


        this.applicationDto.setAnsweredQuestionnaire(this.answeredQuestionnaireDTO);

        applicationDao.insertApplicationForOpportunity(this.applicationDto, this.opportunityDto, this.volunteerDto);
        return "success.xhtml";
    }

    public List<ApplicationDTO> getApplicationList(){
        return applist;
    }
    public void setApplicationList(List<ApplicationDTO> applist){
        this.applist = applist;
    }

    public OpportunityDTO getOpportunityDto() {
        return opportunityDto;
    }

    public void setOpportunityDto(OpportunityDTO opportunityDto) {
        this.opportunityDto = opportunityDto;
    }

    public VolunteerDTO getVolunteerDto() {
        return volunteerDto;
    }

    public void setVolunteerDto(VolunteerDTO volunteerDto) {
        this.volunteerDto = volunteerDto;
    }

    public AnsweredQuestionnaireDTO getAnsweredQuestionnaireDTO() {
        return answeredQuestionnaireDTO;
    }

    public void setAnsweredQuestionnaireDTO(AnsweredQuestionnaireDTO answeredQuestionnaireDTO) {
        this.answeredQuestionnaireDTO = answeredQuestionnaireDTO;
    }
}
