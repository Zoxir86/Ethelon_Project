package com.dao;

import com.dto.QuestionnaireDTO;

public interface QuestionnaireDAO {

    // Inserts a new Questionnaire entity in the database. Uses a DTO as input.
    public boolean insertQuestionnaire(QuestionnaireDTO questionnaire);

    // Deletes an existing Questionnaire entity in the database. Uses a DTO as input.
    public boolean deleteQuestionnaire(QuestionnaireDTO questionnaire);

    // Updates an existing Questionnaire entity in the database. Uses a DTO as input.
    public boolean updateQuestionnaire(QuestionnaireDTO questionnaire);
}
