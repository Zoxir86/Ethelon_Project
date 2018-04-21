package com.dao;

import com.database.Opportunity;
import com.dto.OpportunityDTO;

public class OpportunityDAOImplementation implements OpportunityDAO {

    /******************************************************************************************************************
     Performs transformation from Entities (used by the JPA mechanisms) to DTO (incoming and outgoing calls).
     *****************************************************************************************************************/

    public static OpportunityDTO transformOpportunityEntity2DTO(Opportunity entity)
    {
        OpportunityDTO dto = new OpportunityDTO();
        dto.setDatabaseId(entity.getOpportunityID());
        return dto;
    }


    /******************************************************************************************************************
     Performs transformation from DTO (incoming and outgoing calls) to Entities (used by the JPA mechanisms).
     *****************************************************************************************************************/

    public static Opportunity transformOpportunityDTO2Entity(OpportunityDTO dto)
    {
        Opportunity entity = new Opportunity();
        entity.setOpportunityID(dto.getDatabaseId());
        return entity;
    }
}
