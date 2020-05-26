package com.eis.clientapi.event;

import com.eis.clientapi.repositories.EventRepository;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventHandler implements PostInsertEventListener {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void onPostInsert(PostInsertEvent ePost) {
        /*final Object entity = ePost.getEntity();
        try {
            String data = null, type = null, state = "NEW";
            if(entity instanceof User) {
                data = new ObjectMapper().writeValueAsString((User) entity);
                type = "ADD_USER";
            }
            if(data != null) {
                Event event = new Event(type, data, state);
                eventRepository.save(event);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister entityPersister) {
        return false;
    }
}
