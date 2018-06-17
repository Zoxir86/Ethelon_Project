package com.dao;

import com.dto.AnsweredQuestionnaireDTO;

public interface AnsweredQuestionnaireDAO {

    // Inserts a new AnsweredQuestionnaire entity in the database. Uses a DTO as input.
    public boolean insertAnsweredQuestionnaire(AnsweredQuestionnaireDTO dto);

    // Deletes an existing AnsweredQuestionnaire entity in the database. Uses a DTO as input.
    public boolean deleteAnsweredQuestionnaire(AnsweredQuestionnaireDTO dto);

    // Updates an existing AnsweredQuestionnaire entity in the database. Uses a DTO as input.
    public boolean updateAnsweredQuestionnaire(AnsweredQuestionnaireDTO dto);
}


