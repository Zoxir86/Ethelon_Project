package com.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.Convert;

import com.lists.*;
import com.dto.*;

@FacesConverter("areaconv")
public class AreaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                Areas areaService = (Areas) fc.getExternalContext().getApplicationMap().get("arealist");
                for (AreaDTO area : areaService.getAreaList())
                {
                    if (area.getDatabaseID() == Integer.parseInt(value))
                    {
                        return area;
                    }
                }

                return null;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((AreaDTO) object).getDatabaseID());
        }
        else {
            return null;
        }
    }
}