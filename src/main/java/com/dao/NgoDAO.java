package com.dao;

import com.dto.NgoDTO;

import java.util.ArrayList;

public interface NgoDAO {

    //public boolean logInNgo(String username, String password);
    public boolean insertNgo(NgoDTO ngo);
    public boolean deleteNgo(NgoDTO ngo);
    public boolean updateNgo(NgoDTO ngo);
    //public ArrayList<NgoDTO> searchNgo(String organisation);
}
