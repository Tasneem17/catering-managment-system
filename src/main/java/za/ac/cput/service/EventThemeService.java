package za.ac.cput.service;

import za.ac.cput.entity.EventTheme;

import java.util.List;

public interface EventThemeService extends IService <EventTheme, String>{

        List<EventTheme> findAll();

        }