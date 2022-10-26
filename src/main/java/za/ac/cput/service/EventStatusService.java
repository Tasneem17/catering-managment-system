package za.ac.cput.service;


import za.ac.cput.entity.EventStatus;

import java.util.List;
import java.util.Optional;

public interface EventStatusService {

    Optional<EventStatus> read(String eventStatus);

    void deleteByid(String id);

    List<EventStatus> findAll();
}

