package com.lists;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.dao.KnowledgeAreaDAO;
import com.dao.KnowledgeAreaDAOImplementation;
import com.dto.KnowledgeAreaDTO;

@ManagedBean(name="knowlist", eager = true)
@ApplicationScoped
public class Knowledge {

    private KnowledgeAreaDAO knowledge = new KnowledgeAreaDAOImplementation();
    private List<KnowledgeAreaDTO> knowledgeList = new ArrayList<KnowledgeAreaDTO>();

    @PostConstruct
    public void init(){
        knowledgeList = knowledge.getFullListOfKnowledgeAreas();
    }

    public List<KnowledgeAreaDTO> getKnowledgeList() {
        return knowledgeList;
    }

}