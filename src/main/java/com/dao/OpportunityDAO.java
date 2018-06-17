package com.dao;

import com.dto.OpportunityDTO;

import java.util.ArrayList;

public interface OpportunityDAO {

    // Inserts a new Opportunity entity in the database. Associates the Opportunity with an already existing NGO.
    public boolean insertOpportunity(OpportunityDTO dto);

    // Returns the full list of Opportunities. Returns null if nothing is found.
    public ArrayList<OpportunityDTO> getFullListOfOpportunities();
}
