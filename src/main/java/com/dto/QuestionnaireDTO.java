package com.dto;

import com.database.Question;

import java.util.List;

public class QuestionnaireDTO {

    private int databaseId;                          // A unique identification number in the database.
    private List<QuestionDTO> questionList;             // A list of questions associated with the questionnaire.

    /**************************************  Constructors   ***********************************************/
    public QuestionnaireDTO ( ) {
        super();
    }

    public QuestionnaireDTO(int databaseId, List<QuestionDTO> questionList) {
        this.databaseId = databaseId;
        this.questionList = questionList;
    }

    /***************************************   Getters and Setters   ***************************************/
    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }

    public List<QuestionDTO> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionDTO> questionList) {
        this.questionList = questionList;
    }
} // End of QuestionnaireDTO class.
