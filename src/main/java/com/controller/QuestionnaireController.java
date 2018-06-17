package com.controller;

import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.*;
import com.dto.*;


@ManagedBean (name = "qcontr")
@SessionScoped
public class QuestionnaireController implements Serializable{

    private QuestionnaireDAO questionnaireDao = new QuestionnaireDAOImplementation();
    private QuestionnaireDTO questionnaireDto = new QuestionnaireDTO();
    private QuestionDTO question1 = new QuestionDTO();
    private QuestionDTO question2 = new QuestionDTO();
    private QuestionDTO question3 = new QuestionDTO();
    private List<QuestionDTO> questlist = new ArrayList<QuestionDTO>();


    public QuestionnaireDTO getQuestionnaireDto() {
        return questionnaireDto;
    }

    public void setQuestionnaireDto() {
        questlist.add(question1);
        questlist.add(question2);
        questlist.add(question3);
        this.questionnaireDto.setQuestionList(this.questlist);
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
}
