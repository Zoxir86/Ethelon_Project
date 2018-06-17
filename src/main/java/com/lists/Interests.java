package com.lists;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.dao.InterestDAO;
import com.dao.InterestDAOImplementation;
import com.dto.InterestDTO;

@ManagedBean(name="intlist", eager = true)
@ApplicationScoped
public class Interests {

    private InterestDAO interest = new InterestDAOImplementation();
    private List<InterestDTO> interestList = new ArrayList<InterestDTO>();

    @PostConstruct
    public void init(){
        interestList = interest.getFullListOfInterests();
    }

    public List<InterestDTO> getInterestList() {
        return interestList;
    }

}
