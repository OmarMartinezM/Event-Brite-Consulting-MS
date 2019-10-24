package com.eventbriteconsulting.eventbriteconsulting.service;

import com.eventbriteconsulting.eventbriteconsulting.model.EventDTO;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEventService {

    public List<EventDTO> getEvents(String keyWord) throws JSONException;
    public void notifyTransaction(String message, String status, String service);
    public void notifyException(String message, String service);

}
