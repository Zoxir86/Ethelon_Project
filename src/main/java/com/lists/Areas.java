package com.lists;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.dao.AreaDAO;
import com.dao.AreaDAOImplementation;
import com.dto.AreaDTO;

@ManagedBean(name="arealist", eager = true)
@ApplicationScoped
public class Areas {

    private AreaDAO area = new AreaDAOImplementation();
    private List<AreaDTO> areaList = new ArrayList<AreaDTO>();

    @PostConstruct
    public void init(){
        areaList = area.getFullListOfAreas();
    }

    public List<AreaDTO> getAreaList() {
        return areaList;
    }

}
