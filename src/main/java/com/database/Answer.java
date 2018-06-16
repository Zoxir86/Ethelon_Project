package com.database;

import javax.persistence.*;

@Table(name = "answer")
@Entity(name="Answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", updatable = false, nullable = false)       // A unique identification number in the database.
    private int answerId;

    @Column(name="Position")                                        // The answer's position in the answered questionnaire.
    private int position;

    @Column(name="AnswerText")                                      // The answer's text.
    private String answerText;

    @Column(name="InsertDate")                                      // The date on which the answer was first persisted.
    private String insertDate;

    @Column(name="UpdateDate")                                      // The date on which the answer was last updated.
    private String updateDate;

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Answer() {
        super();
    }

    public Answer(int position, String answerText, String insertDate, String updateDate) {
        this.position = position;
        this.answerText = answerText;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
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

}  // End of Answer class.
