package com.eventbriteconsulting.eventbriteconsulting.controller;

import com.eventbriteconsulting.eventbriteconsulting.model.EventDTO;
import com.eventbriteconsulting.eventbriteconsulting.service.IEventService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventBriteController {

    @Autowired
    private IEventService eventService;


    @GetMapping("/events/{keyWord}")
    public List<EventDTO> getFullEvents(@PathVariable("keyWord") String keyWord) throws JSONException {
        return eventService.getEvents(keyWord);
    }

    @GetMapping("/prueba")
    public String prueba(){
        return "Hello World";
    }
}
