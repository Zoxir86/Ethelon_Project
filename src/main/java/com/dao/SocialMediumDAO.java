package com.dao;

import com.dto.SocialMediumDTO;

import java.util.ArrayList;

public interface SocialMediumDAO {

    // Inserting a new Social Medium entity in the database. Uses a DTO as input. Returns SUCCESS (true) or  ERROR (false).
    public boolean insertSocialMedium(SocialMediumDTO dto);

    // Deleting an existing Social Medium entity in the database. Uses a DTO as input. Returns SUCCESS (true) or  ERROR (false).
    public boolean deleteSocialMedium(SocialMediumDTO dto);

    // Updating an existing Social Medium entity in the database. Uses a DTO as input. Returns SUCCESS (true) or  ERROR (false).
    public boolean updateSocialMedium(SocialMediumDTO dto);

    // Marking an existing Social Medium as inactive/active in the database.
    public boolean changeSocialMediumActiveState(SocialMediumDTO dto);

    // Returning a full list of Social Media. Sorted by importance rank. Returns empty list if nothing is found.
    public ArrayList<SocialMediumDTO> getFullListOfSocialMedia();

    // Returning a full list of active Social Media. Sorted by importance rank. Returns empty list if nothing is found.
    public ArrayList<SocialMediumDTO> getFullListOfActiveSocialMedia();

}
