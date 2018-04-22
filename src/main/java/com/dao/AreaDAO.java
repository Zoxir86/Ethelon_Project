package com.dao;

import com.dto.AreaDTO;

import java.util.ArrayList;

public interface AreaDAO {

    // Returning the area corresponding to a particular Postal Code. Returns null if nothing is found.
    public AreaDTO getAreaRelatedToAPostalCode(String postalCode);

    // Returning a list of Areas whose postal code starts with some digits. Returns null if nothing is found.
    public ArrayList<AreaDTO> getAreasWhosePostalCodeStartsWith(String postalCodeFirstDigits);

    // Returning a list of Areas whose description starts with a combination of some characters. Returns null if nothing is found.
    public ArrayList<AreaDTO> getListOfAreasStartingWith(String areaFirstLetters);

    // Returning a list of Areas whose description starts contains a combination of some characters. Returns null if nothing is found.
    public ArrayList<AreaDTO> getListOfAreasContaining(String areaMiddleLetters);

    // Returning a list of Areas who belong to a particular prefecture. Returns null if nothing is found.
    public ArrayList<AreaDTO> getListOfAreasOfPrefecture(String prefecture);

    // Returning a list of Areas who belong to a particular country. Returns null if nothing is found.
    public ArrayList<AreaDTO> getListOfAreasOfCountry(String country);

    // Returning the full list of Areas. Returns null if nothing is found.
    public ArrayList<AreaDTO> getFullListOfAreas();

    // Returning a list of prefectures who belong to a particular country. Unique values in alphabetical order. Returns null if nothing is found.
    public ArrayList<String> getListOfPrefecturesOfCountry(String country);

    // Returning a full list of prefectures. Unique values in alphabetical order. Returns null if nothing is found.
    public ArrayList<String> getFullListOfPrefectures();

    // Returning a full list of countries. Unique values in alphabetical order. Returns null if nothing is found.
    public ArrayList<String> getFullListOfCountries();
}
