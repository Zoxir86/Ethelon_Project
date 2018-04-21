package com.controller;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.dao.VolunteerDAO;
import com.dto.VolunteerDTO;
import com.dao.VolunteerDAOImplementation;

@ManagedBean (name = "volcontr")
@SessionScoped
public class VolunteerController {


	private VolunteerDAO volunteerDao = new VolunteerDAOImplementation();
	private VolunteerDTO volunteerDto = new VolunteerDTO();
	//public String gender;
	//public String occupation;
	//public String[] interests;

	public VolunteerDTO getVolunteerDto() {
		return volunteerDto;
	}

	public String setVolunteerDto() {
		volunteerDao.insertVolunteer(this.volunteerDto);
		return "success.xhtml";
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
