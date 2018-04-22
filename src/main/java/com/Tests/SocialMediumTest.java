package com.Tests;

import com.dao.SocialMediumDAOImplementation;
import com.dto.SocialMediumDTO;

import java.util.ArrayList;

public class SocialMediumTest {

    public static void main(String args[]) {

        SocialMediumDAOImplementation daoImp = new SocialMediumDAOImplementation();

        // Inserting a new Social Medium entity in the database. Uses a DTO as input. Returns SUCCESS (true) or  ERROR (false).
        SocialMediumDTO dtoTwitter = new SocialMediumDTO(0, "Twitter", "https://twitter.com/", "https://twitter.com/", "Twitter.ico", true, 2);
        daoImp.insertSocialMedium(dtoTwitter);

        SocialMediumDTO dtoFacebook = new SocialMediumDTO(0, "Facebook", "https://www.facebook.com/", "https://www.facebook.com/", "Facebook.ico", true, 1);
        daoImp.insertSocialMedium(dtoFacebook);

        // Deleting an existing Social Medium entity in the database. Uses a DTO as input. Returns SUCCESS (true) or  ERROR (false).
        SocialMediumDTO random = new SocialMediumDTO(1, "", "", "", "", true, 1);
        daoImp.deleteSocialMedium(random);

        // Updating an existing Social Medium entity in the database. Uses a DTO as input. Returns SUCCESS (true) or  ERROR (false).
        SocialMediumDTO random2 = new SocialMediumDTO(51, "NewFacebook", "https://www.newfacebook.com/", "https://www.newfacebook.com/", "NewFacebook.ico", true, 1);
        daoImp.updateSocialMedium(random2);

        // Marking an existing Social Medium as inactive/active in the database.
        daoImp.changeSocialMediumActiveState(random2);

        // Returning a full list of Social Media. Sorted by importance rank. Returns empty list if nothing is found.
        SocialMediumDTO dtoTwitter2 = new SocialMediumDTO(0, "Twitter", "https://twitter.com/", "https://twitter.com/", "Twitter.ico", true, 2);
        daoImp.insertSocialMedium(dtoTwitter2);
        ArrayList<SocialMediumDTO> full = daoImp.getFullListOfSocialMedia();

        // Returning a full list of active Social Media. Sorted by importance rank. Returns empty list if nothing is found.
        ArrayList<SocialMediumDTO> active = daoImp.getFullListOfActiveSocialMedia();
    }
}
