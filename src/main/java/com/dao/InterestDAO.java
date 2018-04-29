package com.dao;

import com.dto.InterestDTO;

import java.util.ArrayList;

public interface InterestDAO {

    // Returning the full list of Interests. Returns null if nothing is found.
    public ArrayList<InterestDTO> getFullListOfInterests();
}
