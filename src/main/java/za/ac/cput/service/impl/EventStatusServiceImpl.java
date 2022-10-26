package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.EventStatus;
import za.ac.cput.repository.EventStatusRepository;
import za.ac.cput.service.EventStatusService;

import java.util.List;
import java.util.Optional;

@Service
public class EventStatusServiceImpl implements EventStatusService {
    private final EventStatusRepository eventStatusRepository;

    @Autowired
    public EventStatusServiceImpl(EventStatusRepository eventStatusRepository){
        this.eventStatusRepository = eventStatusRepository;
    }

    public EventStatus save (EventStatus eventStatus){
        return this.eventStatusRepository.save(eventStatus);
    }

    @Override
    public Optional<EventStatus> read(String eventStatus) {
        return this.eventStatusRepository.findById(eventStatus);
    }

    @Override
    public void deleteByid(String id) {
        this.eventStatusRepository.deleteById(id);
    }

    @Override
    public List<EventStatus> findAll() {
        return this.eventStatusRepository.findAll();
    }
}