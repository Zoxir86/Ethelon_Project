package com.controller;


import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.dao.*;
import com.database.Interest;
import com.database.KnowledgeArea;
import com.database.Volunteer;
import com.dto.AreaDTO;
import com.dto.InterestDTO;
import com.dto.KnowledgeAreaDTO;
import com.dto.VolunteerDTO;
import com.lists.Areas;
import com.lists.Interests;
import com.lists.Knowledge;


@ManagedBean (name = "volcontr")
@SessionScoped
public class VolunteerController implements Serializable {


	private VolunteerDAO volunteerDao = new VolunteerDAOImplementation();
	private VolunteerDTO volunteerDto = new VolunteerDTO();
    private InterestDAO interest = new InterestDAOImplementation();
	private List<InterestDTO> interestList = new ArrayList<InterestDTO>();
	public List<InterestDTO> userInterestList = new ArrayList<InterestDTO>();
	private KnowledgeAreaDAO knowledge = new KnowledgeAreaDAOImplementation();
	private List<KnowledgeAreaDTO> knowledgeList = new ArrayList<KnowledgeAreaDTO>();
	public List<KnowledgeAreaDTO> userKnowledgeList = new ArrayList<KnowledgeAreaDTO>();
	private AreaDAO area = new AreaDAOImplementation();
	private List<AreaDTO> areaList = new ArrayList<AreaDTO>();
    public List<AreaDTO> userAreaList = new ArrayList<AreaDTO>();

    @ManagedProperty("#{intlist}")
    private Interests interService;
    @ManagedProperty("#{knowlist}")
    private Knowledge knowlService;
    //@ManagedProperty("#{arealist}")
    //private Areas areaService;

    @PostConstruct
    public void init(){
        interestList = interService.getInterestList();
        knowledgeList = knowlService.getKnowledgeList();
        //areaList = areaService.getAreaList();options = new ArrayList<String>();
    }

	public VolunteerDTO getVolunteerDto() {
	    return volunteerDto;
	}

	public String setVolunteerDto() {

		this.volunteerDto.setInterestsList(this.userInterestList);
		this.volunteerDto.setKnowledgeAreasList(this.userKnowledgeList);
		this.volunteerDto.setArea(null);

		volunteerDao.insertVolunteer(this.volunteerDto);

		return "success.xhtml";
	}

	public String updateVolunteerDto(){

		this.volunteerDto.setInterestsList(this.userInterestList);
		this.volunteerDto.setKnowledgeAreasList(this.userKnowledgeList);
		this.volunteerDto.setArea(null);

		volunteerDao.updateVolunteer(this.volunteerDto);

		return "success.xhtml";
	}

	public List<InterestDTO> getInterestList() {
    	return interestList;
	}

    public void setInterService(Interests interService) {
        this.interService = interService;
    }

	/*public List<InterestDTO> getUserInterestList(){
	    return new InterestDAOImplementation().getFullListOfInterests();
	}*/

    public List<InterestDTO> getUserInterestList() {
        return userInterestList;
    }

	public void setUserInterestList(List<InterestDTO> userInterestList){
		this.userInterestList = userInterestList;
	}


	public List<KnowledgeAreaDTO> getKnowledgeList() {
    	return knowledgeList;
	}

    public void setKnowlService(Knowledge knowlService) {
        this.knowlService = knowlService;
    }

	/*public List<KnowledgeAreaDTO> getUserKnowledgeList(){
		return new KnowledgeAreaDAOImplementation().getFullListOfKnowledgeAreas();
	}*/

    public List<KnowledgeAreaDTO> getUserKnowledgeList() {
        return userKnowledgeList;
    }

	public void setUserKnowledgeList(List<KnowledgeAreaDTO> userKnowledgeList){
		this.userKnowledgeList = userKnowledgeList;
	}


    public List<AreaDTO> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<AreaDTO> areaList) {
        this.areaList = areaList;
    }

	/*public List<AreaDTO> getAreaList() {
    	return areaList;
	}

    public void setAreaService(Areas areaService) {
        this.areaService = areaService;
    }*/

    /*public List<AreaDTO> getUserAreaList() {
        return userAreaList;
    }

	public void setUserAreaList(List<AreaDTO> userAreaList) {
		this.userAreaList = userAreaList;
	}*/

	public String backPage() {
		return "welcome.xhtml";
	}

	public String successUser() {
		return "success.xhtml";
	}
}
