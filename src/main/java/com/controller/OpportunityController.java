package com.controller;

import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

import com.dao.*;
import com.dto.*;
import com.lists.Interests;
import com.lists.Knowledge;
import com.session.SessionUtils;


@ManagedBean (name = "oppcontr")
@SessionScoped
public class OpportunityController implements Serializable{

    private OpportunityDAO opportunityDao = new OpportunityDAOImplementation();
    private OpportunityDTO opportunityDto = new OpportunityDTO();
    private InterestDAO interest = new InterestDAOImplementation();
    private List<InterestDTO> interestList = new ArrayList<InterestDTO>();
    public List<InterestDTO> oppInterestList = new ArrayList<InterestDTO>();
    private KnowledgeAreaDAO knowledge = new KnowledgeAreaDAOImplementation();
    private List<KnowledgeAreaDTO> knowledgeList = new ArrayList<KnowledgeAreaDTO>();
    public List<KnowledgeAreaDTO> oppKnowledgeList = new ArrayList<KnowledgeAreaDTO>();
    private AreaDAO area = new AreaDAOImplementation();
    private List<AreaDTO> areaList = new ArrayList<AreaDTO>();
    public List<AreaDTO> oppAreaList = new ArrayList<AreaDTO>();
    private QuestionnaireDAO questionnaireDao = new QuestionnaireDAOImplementation();
    private QuestionnaireDTO questionnaireDto = new QuestionnaireDTO();
    private QuestionDTO question1 = new QuestionDTO();
    private QuestionDTO question2 = new QuestionDTO();
    private QuestionDTO question3 = new QuestionDTO();
    private List<QuestionDTO> questlist = new ArrayList<QuestionDTO>();


    @ManagedProperty("#{intlist}")
    private Interests interService;
    @ManagedProperty("#{knowlist}")
    private Knowledge knowlService;


    @PostConstruct
    public void init(){
        interestList = interService.getInterestList();
        knowledgeList = knowlService.getKnowledgeList();
    }


    public OpportunityDTO getOpportunityDto() {

        return opportunityDto;
    }

    public String setOpportunityDto() {
        this.opportunityDto.setKnowledgeAreasList(this.oppKnowledgeList);
        this.opportunityDto.setSecondaryCategoriesList(this.oppInterestList);
        this.opportunityDto.setQuestionnaire(this.questionnaireDto);

        opportunityDao.insertOpportunity(this.opportunityDto);
        return "success.xhtml";
    }

    public List<InterestDTO> getInterestList() {
        return interestList;
    }

    public void setInterService(Interests interService) {
        this.interService = interService;
    }

    public List<InterestDTO> getOppInterestList() {
        return oppInterestList;
    }

    public void setOppInterestList(List<InterestDTO> oppInterestList){
        this.oppInterestList = oppInterestList;
    }

    public List<KnowledgeAreaDTO> getKnowledgeList() {
        return knowledgeList;
    }

    public void setKnowlService(Knowledge knowlService) {
        this.knowlService = knowlService;
    }

    public List<KnowledgeAreaDTO> getOppKnowledgeList() {
        return oppKnowledgeList;
    }

    public void setOppKnowledgeList(List<KnowledgeAreaDTO> oppKnowledgeList){
        this.oppKnowledgeList = oppKnowledgeList;
    }


    public List<AreaDTO> getAreaList() {
        areaList = area.getFullListOfAreas();

        return areaList;
    }

    public List<AreaDTO> getOppAreaList(){

        return new AreaDAOImplementation().getFullListOfAreas();
    }

    public void setOppAreaList(List<AreaDTO> oppAreaList) {
        this.oppAreaList = oppAreaList;
    }

    public QuestionnaireDTO getQuestionnaireDto() {

        return questionnaireDto;
    }

    public void setQuestionnaireDto() {
        questlist.add(question1);
        questlist.add(question2);
        questlist.add(question3);
        this.questionnaireDto.setQuestionList(this.questlist);
        questionnaireDao.insertQuestionnaire(this.questionnaireDto);
    }

    public String checkOpportunity() {
        boolean check = OpportunityDAOImplementation.findOpportunityById();
        if (check) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("title", opportunityDto.getEnglishTitle());
            session.setAttribute("description", opportunityDto.getEnglishDescription());
            session.setAttribute("area", opportunityDto.getArea());
            session.setAttribute("opdate", opportunityDto.getOpenDate());
            session.setAttribute("cldate", opportunityDto.getCloseDate());
            session.setAttribute("knowl", opportunityDto.getKnowledgeAreasList());
            session.setAttribute("inter", opportunityDto.getSecondaryCategoriesList());

            return "activity";
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Something went wrong...",
                            "The activity you're searching for is not valid."));
            return "login";
        }
    }

    public List<QuestionDTO> getQuestlist() {
        return questlist;
    }

    public void setQuestlist(List<QuestionDTO> questlist) {
        this.questlist = questlist;
    }

    public QuestionDTO getQuestion1() {
        return question1;
    }

    public void setQuestion1( QuestionDTO question1) {
        this.question1 = question1;
    }

    public QuestionDTO getQuestion2() {
        return question2;
    }

    public void setQuestion2( QuestionDTO question2) {
        this.question2 = question2;
    }

    public QuestionDTO getQuestion3() {
        return question3;
    }

    public void setQuestion3( QuestionDTO question3) {
        this.question3 = question3;
    }

    public String backPage() {
        return "welcome.xhtml";
    }

    public String questionnairePage() { return "questionnaire.xhtml"; }

    public String successOpp() {
        return "success.xhtml";
    }
}
