/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;


import za.ac.cput.entity.EventTheme;

import java.util.HashSet;
import java.util.Set;

public class EventThemeRepository implements IEventThemeRepository{
    private static EventThemeRepository repository = null;
    private Set<EventTheme>eventThemeDB = null;

    private EventThemeRepository(){
        eventThemeDB = new HashSet<EventTheme>();
    }

    public static EventThemeRepository getRepository(){
        if (repository ==null){
            repository = new EventThemeRepository();

        }
        return repository;
    }


    @Override
    public EventTheme create(EventTheme eventtheme){
        this.eventThemeDB.add(eventtheme);
        return eventtheme;
    }



    @Override
    public EventTheme read(String eventId){
        for (EventTheme c: eventThemeDB) {
            if (c.getEventId().equals(eventId)){
                return c;
            }

        }
        return null;
    }
    @Override
    public EventTheme update(EventTheme eventTheme) {
        EventTheme firstEventTheme = read(eventTheme.getEventId());
        if( firstEventTheme !=null) {
            eventThemeDB.remove(firstEventTheme);
            eventThemeDB.add(eventTheme);
            return eventTheme;
        }
        return null;
    }



    @Override
    public boolean delete(String eventID) {
        EventTheme deleteEventTheme= read(eventID);
        if (deleteEventTheme ==null) {
            System.out.println("EventTheme is null.");
        }
        eventThemeDB.remove(deleteEventTheme);
        System.out.println("EventTheme Removed.");
        return false;
    }
    @Override
    public Set<EventTheme> getAll(){return eventThemeDB;}
}
