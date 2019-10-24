package com.eventbriteconsulting.eventbriteconsulting.service;

import com.eventbriteconsulting.eventbriteconsulting.model.EventDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImp implements IEventService{

    @Autowired
    private IObjectMapperService objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ILogService logService;

    @Value("${spring.application.name}")
    private String appName;

    private String url = "https://www.eventbriteapi.com/v3/events/search/";
    private String token = "E3I22BD7IDZ2RHPMDF5B";

    @HystrixCommand(fallbackMethod = "emptyEvents")
    @Override
    public List<EventDTO> getEvents(String keyWord) throws JSONException {
        HttpEntity<String> entity = new HttpEntity<>(new HttpHeaders());

        List<EventDTO> events = objectMapper.convertStringToListEvents(
                  restTemplate.exchange(url + "?q=" + keyWord + "&token=" + token,  HttpMethod.GET,entity, String.class).getBody()
           );

           notifyTransaction("Events successfully retrieved",HttpStatus.OK.toString(),appName);
           return events;
    }

    @HystrixCommand(fallbackMethod = "logFailure")
    @Override
    public void notifyTransaction(String message, String status, String service) {
        logService.notifyLogTransactions(message,status, service);
    }

    @HystrixCommand(fallbackMethod = "logFailure")
    @Override
    public void notifyException(String message, String service) {
        logService.notifyLogErrors(message, service);
    }

    public void logFailure(){
        System.err.println("Failure while trying to send log message");
    }

    public List<EventDTO> emptyEvents(String keyWord){
        notifyException("Failure while trying to get the events", appName);
        return new ArrayList<>();
    }
}
