package com.dao;

import com.dto.NgoDTO;
import com.dto.OpportunityDTO;

import java.util.ArrayList;

public interface OpportunityDAO {

    // Inserts a new Opportunity entity in the database. Associates the Opportunity with an already existing NGO.
    public boolean insertOpportunity(OpportunityDTO dto);

    // Returns the full list of Opportunities. Returns null if nothing is found.
    public ArrayList<OpportunityDTO> getFullListOfOpportunities();

    //Returns a list of the Opportunities that are open and not hidden. Also checks whether the respective Ngo is approved and not hidden.
    //Returns null if nothing is found.
    public ArrayList<OpportunityDTO> getListOfOpenNotHiddenOpportunities();

    // Marks an opportunity as Hidden from the frontend.
    public boolean markOpportunityAsHidden(OpportunityDTO dto);

    // Closes an opportunity so applications may no longer be submitted.
    public boolean markOpportunityAsClosed(OpportunityDTO dto);

    // Returns a list of the Opportunities that are open and not hidden for a particular Ngo. Also checks whether
    // the Ngo is approved and not hidden. Returns null if nothing is found.
    public ArrayList<OpportunityDTO> getListOfOpenNotHiddenOpportunitiesForParticularNgo(NgoDTO organization);
}
