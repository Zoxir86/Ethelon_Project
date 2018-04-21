package com.dao;

import com.dto.ApplicationDTO;
import com.dto.OpportunityDTO;
import com.dto.VolunteerDTO;

public interface ApplicationDAO {

    public boolean insertApplicationForOpportunity(ApplicationDTO applicationDTO, OpportunityDTO opportunityDTO, VolunteerDTO volunteerDTO);
    public OpportunityDTO getRelatedOpportunityOfApplication(ApplicationDTO applicationDTO);
    public VolunteerDTO getRelatedVolunteerOfApplication(ApplicationDTO applicationDTO);
    public boolean markApplicationAsPending(ApplicationDTO applicationDTO);
    public boolean markApplicationAsApproved(ApplicationDTO applicationDTO);
    public boolean markApplicationAsDisapproved(ApplicationDTO applicationDTO);
    public boolean markApplicationAsWithdrawnByVolunteer(ApplicationDTO applicationDTO);
    public boolean markApplicationAsCancelledByAdministrator(ApplicationDTO applicationDTO);
}
