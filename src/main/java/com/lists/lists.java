package com.lists;

import com.dao.InterestDAO;
import com.dao.InterestDAOImplementation;
import com.dao.KnowledgeAreaDAO;
import com.dao.KnowledgeAreaDAOImplementation;
import com.dto.InterestDTO;
import com.dto.KnowledgeAreaDTO;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;


@ManagedBean(name="objlist", eager = true)
@ApplicationScoped
public class lists {

    private String[] selectedInterests;
    private String[] selectedKnowledge;
    private InterestDAO interest = new InterestDAOImplementation();
    private KnowledgeAreaDAO knowledge = new KnowledgeAreaDAOImplementation();
    private List<InterestDTO> interestList = new ArrayList<InterestDTO>();
    private List<KnowledgeAreaDTO> knowledgeList = new ArrayList<KnowledgeAreaDTO>();

    @PostConstruct
    public void init(){
        interestList=interest.getFullListOfInterests();
        knowledgeList=knowledge.getFullListOfKnowledgeAreas();
    }

    public String[] getSelectedInterests() {
        return selectedInterests;
    }

    public void setSelectedInterests(String[] selectedInterests) {
        this.selectedInterests = selectedInterests;
    }

    public String[] getSelectedKnowledge() {
        return selectedKnowledge;
    }

    public void setSelectedKnowledge(String[] selectedKnowledge) {
        this.selectedKnowledge = selectedKnowledge;
    }
    public List<InterestDTO> getInterestList() {
        return interestList;
    }

    public List<KnowledgeAreaDTO> getKnowledgeList() {
        return knowledgeList;
    }
}
