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

@FacesConverter("knowlconv")
public class KnowlConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                Knowledge knowlService = (Knowledge) fc.getExternalContext().getApplicationMap().get("knowlist");
                for (KnowledgeAreaDTO knowledge : knowlService.getKnowledgeList())
                {
                    if (knowledge.getDatabaseID() == Integer.parseInt(value))
                    {
                        return knowledge;
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
            return String.valueOf(((KnowledgeAreaDTO) object).getDatabaseID());
        }
        else {
            return null;
        }
    }
}
