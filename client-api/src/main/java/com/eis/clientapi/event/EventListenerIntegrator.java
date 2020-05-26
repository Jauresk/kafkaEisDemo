package com.eis.clientapi.event;

import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Component
public class EventListenerIntegrator {

    @PersistenceUnit
    private EntityManagerFactory em;

    @Autowired
    private EventHandler eventHandler;

    @PostConstruct
    protected void init() {

        SessionFactoryImpl sessionFactory = em.unwrap(SessionFactoryImpl.class);
        ServiceRegistry serviceRegistry = sessionFactory.getServiceRegistry();
        final EventListenerRegistry eventListenerRegistry = serviceRegistry.getService(EventListenerRegistry.class);

        eventListenerRegistry.appendListeners(EventType.POST_INSERT, eventHandler);

    }
}
