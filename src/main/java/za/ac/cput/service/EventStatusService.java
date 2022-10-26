package za.ac.cput.service;


import za.ac.cput.entity.Category;
import za.ac.cput.entity.EventStatus;

import java.util.List;
import java.util.Optional;

public interface EventStatusService {

    EventStatus save(EventStatus eventStatus);
    Optional<EventStatus> read(String eventStatus);

    boolean deleteById(String id);

    List<EventStatus> findAll();
}

