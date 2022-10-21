package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.EventTheme;

import za.ac.cput.repository.EventThemeRepository;

import za.ac.cput.service.EventThemeService;

import java.util.List;
import java.util.Optional;

@Service
public class EventThemeServiceImpl implements EventThemeService {

    private final EventThemeRepository eventThemeRepository;

    @Autowired
    public EventThemeServiceImpl(EventThemeRepository eventThemeRepository) {
        this.eventThemeRepository = eventThemeRepository;
    }

    @Override
    public EventTheme save(EventTheme eventTheme) {
        return this.eventThemeRepository.save(eventTheme);
    }


    @Override
    public Optional<EventTheme> read(String s) {
        return this.eventThemeRepository.findById(s);
    }

    @Override
    public boolean delete(EventTheme eventTheme) {
        this.eventThemeRepository.delete(eventTheme);
        return false;
    }

    @Override
    public boolean deletebyid(String id) {
        this.eventThemeRepository.deleteById(id);
        return false;
    }

    @Override
    public List<EventTheme> findAll () {
        return null;
    }

}