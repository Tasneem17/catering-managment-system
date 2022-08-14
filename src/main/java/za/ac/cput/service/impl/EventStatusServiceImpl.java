package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.EventStatus;
import za.ac.cput.repository.IEventStatusRepository;
import za.ac.cput.service.EventStatusService;

import java.util.List;
import java.util.Optional;

@Service
public class EventStatusServiceImpl implements EventStatusService {
    private final IEventStatusRepository repository;
    public EventStatusServiceImpl(IEventStatusRepository repository){
        this.repository = repository;
    }
    @Override
    public EventStatus save (EventStatus eventStatus){
        return this.repository.save(eventStatus);
    }
    @Override
    public Optional<EventStatus> read(String eventStatus) {
        return this.repository.read(eventStatus);
    }
    @Override
    public void delete(EventStatus eventStatus){
        this.repository.delete(eventStatus);
    }

    @Override
    public List<EventStatus> findAllEvent_id(String eventStatus) {
        return this.repository.findAll();
    }
}