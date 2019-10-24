package com.eventbriteconsulting.eventbriteconsulting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EventBritteConfig {

    @Bean
    public RestTemplate restTemplate(){ return new RestTemplate();}

}
