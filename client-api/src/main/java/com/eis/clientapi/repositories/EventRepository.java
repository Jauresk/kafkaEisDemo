package com.eis.clientapi.repositories;

import com.eis.clientapi.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
