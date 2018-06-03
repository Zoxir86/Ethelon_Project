package com.controller;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.*;
import com.dto.InterestDTO;
import com.dto.KnowledgeAreaDTO;
import com.dto.VolunteerDTO;

@ManagedBean (name = "volcontr")
@SessionScoped
public class VolunteerController {


	private VolunteerDAO volunteerDao = new VolunteerDAOImplementation();
	private VolunteerDTO volunteerDto = new VolunteerDTO();
	//public String gender;
	//public String occupation;
	//public String[] interests;
    private InterestDAO interest = new InterestDAOImplementation();
	private List<InterestDTO> interestList = new ArrayList<InterestDTO>();
	public List<InterestDTO> userInterestList = new ArrayList<InterestDTO>();
	private KnowledgeAreaDAO knowledge = new KnowledgeAreaDAOImplementation();
	private List<KnowledgeAreaDTO> knowledgeList = new ArrayList<KnowledgeAreaDTO>();
	public List<KnowledgeAreaDTO> userKnowledgeList = new ArrayList<KnowledgeAreaDTO>();

	public String[] favNumber4;


	public VolunteerDTO getVolunteerDto() {
		return volunteerDto;
	}

	public String setVolunteerDto() {
		//this.volunteerDto.setInterestsList(this.userInterestList);

		volunteerDao.insertVolunteer(this.volunteerDto);
		return "success.xhtml";
	}


	public List<InterestDTO> getInterestList() {
	    interestList = interest.getFullListOfInterests();

		return interestList;
	}

	public List<InterestDTO> getUserInterestList(){
		return new InterestDAOImplementation().getFullListOfInterests();
	}

	public void setUserInterestList(List<InterestDTO> userInterestList){
		this.userInterestList = userInterestList;
	}


	public List<KnowledgeAreaDTO> getKnowledgeList() {
		knowledgeList = knowledge.getFullListOfKnowledgeAreas();

		return knowledgeList;
	}

	public List<KnowledgeAreaDTO> getUserKnowledgeList(){
		return new KnowledgeAreaDAOImplementation().getFullListOfKnowledgeAreas();
	}

	public void setUserKnowledgeList(List<KnowledgeAreaDTO> userKnowledgeList){
		this.userKnowledgeList = userKnowledgeList;
	}

	/*public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender=gender;
	}

	public String getOccupation()
	{
		return occupation;
	}

	public void setOccupation(String occupation)
	{
		this.occupation=occupation;
	}

	public String getInterestsInString() {
		return Arrays.toString(interests);
	}

	public void setInterestsInString(String[] interests) {
		this.interests=interests;
	}

	private static Map<String,Object> interests2Value;
	static{
		interests2Value = new LinkedHashMap<String,Object>();
		interests2Value.put("Animals", "Animals");
		interests2Value.put("Nature", "Nature");
	}

	public Map<String,Object> getInterests2Value() {
		return interests2Value;
	}*/

	public String backPage() {
		return "welcome.xhtml";
	}

	public String successUser() {
		return "success.xhtml";
	}
}
