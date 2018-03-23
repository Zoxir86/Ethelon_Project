package com.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.dao.NgoDAO;
import com.dao.NgoDAOImplementation;


import com.dto.NgoDTO;


@ManagedBean (name = "ngocontr")
@SessionScoped
public class NgoController {


    private NgoDAO ngoDao = new NgoDAOImplementation();
    private NgoDTO ngoDto = new NgoDTO();

    public NgoDTO getNgoDto() {
        return ngoDto;
    }

    public String setNgoDto() {
        ngoDao.insertNgo(this.ngoDto);
        return "success.xhtml";
    }


    public String backPage() {
        return "welcome.xhtml";
    }

    public String successUser() {
        return "success.xhtml";
    }
}