/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;


import za.ac.cput.entity.Event;

import java.util.HashSet;
import java.util.Set;

public class EventRepository implements IEventRepository{
    private static EventRepository repository = null;
    private Set<Event> eventDB = null;

    private EventRepository(){
        eventDB = new HashSet<Event>();
    }

    public static EventRepository getRepository(){
        if (repository ==null){
            repository = new EventRepository();

        }
        return repository;
    }


    @Override
    public Event create(Event event){
        this.eventDB.add(event);
        return event;
    }



    @Override
    public Event read(String eventId){
        for (Event c: eventDB) {
            if (c.getEventId().equals(eventId)){
                return c;
            }

        }
        return null;
    }
    @Override
    public Event update(Event event) {
        Event firstEvent = read(event.getEventId());
        if( firstEvent !=null) {
            eventDB.remove(firstEvent);
            eventDB.add(event);
            return event;
        }
        return null;
    }



    @Override
    public boolean delete(String eventID) {
        Event deleteEvent = read(eventID);
        if (deleteEvent ==null) {
            System.out.println("Event is null.");
        }
        eventDB.remove(deleteEvent);
        System.out.println("Event Removed.");
        return false;
    }
    @Override
    public Set<Event> getAll(){return eventDB;}
}
