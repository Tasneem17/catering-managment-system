package za.ac.cput.service;


import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Event;

import java.util.List;

@Repository
public interface EventService extends IService<Event, String> {

    List<Event> findAll();

}