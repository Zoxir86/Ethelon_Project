package com.lists;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.dao.QuestionnaireDAO;
import com.dao.QuestionnaireDAOImplementation;
import com.dto.QuestionDTO;
import com.dto.QuestionnaireDTO;


@ManagedBean(name="qstlist", eager = true)
@ApplicationScoped
public class Questions {

    private QuestionnaireDAO questionnaire = new QuestionnaireDAOImplementation();
    private QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
    private List<QuestionDTO> questionList = new ArrayList<QuestionDTO>();

    @PostConstruct
    public void init(){
        questionnaireDTO.setQuestionList(questionList);
        questionnaire.insertQuestionnaire(questionnaireDTO);
    }

    public List<QuestionDTO> getQuestion() {
        return questionList;
    }

}
