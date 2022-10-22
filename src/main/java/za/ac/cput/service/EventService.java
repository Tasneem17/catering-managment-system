package za.ac.cput.service;


import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Event;
import za.ac.cput.service.IService;

import java.util.List;

@Repository
public interface EventService extends IService<Event, String> {

    boolean deletebyid(String id);

    List<Event> findAll();

}