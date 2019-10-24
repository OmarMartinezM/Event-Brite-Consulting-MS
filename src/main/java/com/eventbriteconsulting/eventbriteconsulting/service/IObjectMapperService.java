package com.eventbriteconsulting.eventbriteconsulting.service;

import com.eventbriteconsulting.eventbriteconsulting.model.EventDTO;
import org.json.JSONException;
import java.util.List;

public interface IObjectMapperService {

    public List<EventDTO> convertStringToListEvents(String events) throws JSONException;
}
