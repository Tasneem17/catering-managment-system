package za.ac.cput.service;

import org.springframework.stereotype.Repository;
import za.ac.cput.entity.EventTheme;
import za.ac.cput.service.IService;

import java.util.List;

//@Repository
public interface EventThemeService extends IService <EventTheme, String>{

        boolean deletebyid(String id);
        List<EventTheme> findAll();

        }