package com.database;

import javax.persistence.*;
import java.util.List;

@Table(name = "questionnaire")
@Entity(name="Questionnaire")
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", updatable = false, nullable = false)       // A unique identification number in the database.
    private int questionnaireId;

    @OneToMany( targetEntity=Question.class )                       // A list of questions associated with the questionnaire.
    private List<Question> questionList;

    @Column(name="InsertDate")                                      // The date on which the questionnaire was first persisted.
    private String insertDate;

    @Column(name="UpdateDate")                                      // The date on which the questionnaire was last updated.
    private String updateDate;

    /**************************************  Constructors   ***********************************************/
    public Questionnaire( ) {
        super();
    }

    public Questionnaire(List<Question> questionList) {
        this.questionList = questionList;
    }

    /***************************************   Getters and Setters   ***************************************/
    public int getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(int questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
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
} // End of Questionnaire class.
