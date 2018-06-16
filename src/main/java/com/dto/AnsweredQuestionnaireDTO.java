package com.dto;

import java.util.List;

public class AnsweredQuestionnaireDTO {

    private int databaseId;                             // A unique identification number in the database.
    private List<AnswerDTO> answersList;                // A list of answers associated with the answered questionnaire.
    private QuestionnaireDTO questionnaire;             // The Questionnaire for which the AnsweredQuestionnaire provides answers to.
    private String insertDate;                          // The date on which the answered questionnaire was first persisted.
    private String updateDate;                          // The date on which the answered questionnaire was last updated.


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public AnsweredQuestionnaireDTO( ) {
        super();
    }

    public AnsweredQuestionnaireDTO(int databaseId, List<AnswerDTO> answersList, QuestionnaireDTO questionnaire, String insertDate, String updateDate) {
        this.databaseId = databaseId;
        this.answersList = answersList;
        this.questionnaire = questionnaire;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }

    public List<AnswerDTO> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<AnswerDTO> answersList) {
        this.answersList = answersList;
    }

    public QuestionnaireDTO getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(QuestionnaireDTO questionnaire) {
        this.questionnaire = questionnaire;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

}   // End of AnsweredQuestionnaireDTO class.
