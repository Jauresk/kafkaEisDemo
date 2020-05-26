package com.eis.clientapi.event;

import com.eis.clientapi.entities.Event;
import com.eis.clientapi.repositories.EventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher<T> {

    @Autowired
    private EventRepository eventRepository;

    public void publish(T object, String type){
        try {
            String state = "NEW", data = new ObjectMapper().writeValueAsString(object);
            Event event = new Event(type, data, state);
            eventRepository.save(event);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
