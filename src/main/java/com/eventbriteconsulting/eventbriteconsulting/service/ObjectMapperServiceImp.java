package com.eventbriteconsulting.eventbriteconsulting.service;

import com.eventbriteconsulting.eventbriteconsulting.model.EventDTO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjectMapperServiceImp implements IObjectMapperService{

    @Override
    public List<EventDTO> convertStringToListEvents(String events) throws JSONException {
        JSONArray a = (JSONArray) new JSONObject(events).get("events");
        List<EventDTO> eventList = new ArrayList();
        for(int i = 0; i < a.length(); i++){
            JSONObject j = a.getJSONObject(i);
            EventDTO e = new EventDTO();
            e.setDescription(new JSONObject(j.getString("description")).getString("text"));
            e.setSummary(j.getString("summary"));
            e.setLocation(j.getString("locale"));
            e.setStart(new JSONObject(j.getString("start")).getString("local"));
            e.setEnd(new JSONObject(j.getString("start")).getString("local"));
            eventList.add(e);
        }
        return eventList;
    }
}
