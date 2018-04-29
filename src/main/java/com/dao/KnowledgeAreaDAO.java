package com.dao;

import com.dto.KnowledgeAreaDTO;

import java.util.ArrayList;

public interface KnowledgeAreaDAO {

    // Returning the full list of KnowledgeAreas. Returns null if nothing is found.
    public ArrayList<KnowledgeAreaDTO> getFullListOfKnowledgeAreas();
}
