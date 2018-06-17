package com.database;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "answeredQuestionnaire")
@Entity(name="AnsweredQuestionnaire")
public class AnsweredQuestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", updatable = false, nullable = false)       // A unique identification number in the database.
    private int answeredQuestionnaireId;

    @OneToMany( targetEntity=Answer.class )                         // A list of answers associated with the answered questionnaire.
    private List<Answer> answersList;

    @ManyToOne                                                      // The Questionnaire for which the AnsweredQuestionnaire provides answers to.
    private Questionnaire questionnaire;

    @Column(name="InsertDate")                                      // The date on which the answered questionnaire was first persisted.
    private String insertDate;

    @Column(name="UpdateDate")                                      // The date on which the answered questionnaire was last updated.
    private String updateDate;


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public AnsweredQuestionnaire( ) {
        super();
    }

    public AnsweredQuestionnaire(List<Answer> answersList, Questionnaire questionnaire, String insertDate, String updateDate) {
        this.answersList = answersList;
        this.questionnaire = questionnaire;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public int getAnsweredQuestionnaireId() {
        return answeredQuestionnaireId;
    }

    public void setAnsweredQuestionnaireId(int answeredQuestionnaireId) {
        this.answeredQuestionnaireId = answeredQuestionnaireId;
    }

    public List<Answer> getAnswersList() {
        if (answersList == null) answersList = new ArrayList<Answer>();
        return answersList;
    }

    public void setAnswersList(List<Answer> answersList) {
        this.answersList = answersList;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
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

}  // End of AnsweredQuestionnaire class.
