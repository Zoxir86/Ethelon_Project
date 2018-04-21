package com.database;

import javax.persistence.*;

@Table(name = "question")
@Entity(name="Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", updatable = false, nullable = false)       // A unique identification number in the database.
    private int questionId;

    @Column(name="Position")                                        // The question's position in the questionnaire.
    private int position;

    @Column(name="EnglishText")                                     // The question's text in English.
    private String textEnglish;

    @Column(name="GreekText")                                       // The question's text in Greek.
    private String textGreek;

    @Column(name="InsertDate")                                      // The date on which the question was first persisted.
    private String insertDate;

    @Column(name="UpdateDate")                                      // The date on which the question was last updated.
    private String updateDate;


    /**************************************  Constructors   ***********************************************/
    public Question( ) {
        super();
    }

    public Question(int position, String textEnglish, String textGreek) {
        this.position = position;
        this.textEnglish = textEnglish;
        this.textGreek = textGreek;
    }

    /***************************************   Getters and Setters   ***************************************/
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int index) {
        this.position = index;
    }

    public String getTextEnglish() {
        return textEnglish;
    }

    public void setTextEnglish(String textEnglish) {
        this.textEnglish = textEnglish;
    }

    public String getTextGreek() {
        return textGreek;
    }

    public void setTextGreek(String textGreek) {
        this.textGreek = textGreek;
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

} // End of Question class.


