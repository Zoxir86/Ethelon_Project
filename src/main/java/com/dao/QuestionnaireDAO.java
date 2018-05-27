package com.dao;

import com.database.Questionnaire;
import com.dto.QuestionnaireDTO;

public interface QuestionnaireDAO {
    public boolean insertQuestionnaire(QuestionnaireDTO questionnaire);
    public boolean deleteQuestionnaire(QuestionnaireDTO questionnaire);
    public boolean updateQuestionnaire(QuestionnaireDTO questionnaire);
}
