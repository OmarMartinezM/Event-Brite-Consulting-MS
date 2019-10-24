package com.eventbriteconsulting.eventbriteconsulting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private String summary;
    private String start;
    private String end;
    private String location;
    private String description;

    public EventDTO(String summary){
        this.summary = summary;
    }

}
