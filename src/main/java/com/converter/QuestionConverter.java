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

@FacesConverter("questconv")
public class QuestionConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                Questions questService = (Questions) fc.getExternalContext().getApplicationMap().get("qstlist");
                for (QuestionDTO question : questService.getQuestion())
                {
                    if (question.getDatabaseId() == Integer.parseInt(value))
                    {
                        return question;
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
            return String.valueOf(((QuestionDTO) object).getDatabaseId());
        }
        else {
            return null;
        }
    }
}
