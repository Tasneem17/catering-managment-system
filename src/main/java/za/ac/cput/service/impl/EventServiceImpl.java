package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Event;
import za.ac.cput.repository.EventRepository;
import za.ac.cput.service.EventService;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event save(Event event) {
        return this.eventRepository.save(event);
    }


    @Override
    public Optional<Event> read(String s) {
        return this.eventRepository.findById(s);
    }

    @Override
    public boolean delete(Event event) {
        this.eventRepository.delete(event);
        return false;
    }

    @Override
    public List<Event> findAll () {
        return null;
    }

}