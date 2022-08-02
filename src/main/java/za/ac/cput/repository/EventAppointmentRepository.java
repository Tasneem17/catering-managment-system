/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;

import za.ac.cput.entity.EventAppointment;

import java.util.HashSet;
import java.util.Set;


    public class EventAppointmentRepository implements IEventAppointmentRepository{
        private static za.ac.cput.repository.EventAppointmentRepository repository = null;
        private Set<EventAppointment> eventAppointmentDB = null;

        private EventAppointmentRepository(){
            eventAppointmentDB = new HashSet<EventAppointment>();
        }

        public static za.ac.cput.repository.EventAppointmentRepository getRepository() {
            if (repository == null) {
                repository = new EventAppointmentRepository();

            }
            return repository;
        }


        @Override
        public EventAppointment create(EventAppointment eventappointment){
            this.eventAppointmentDB.add(eventappointment);
            return eventappointment;
        }



        @Override
        public EventAppointment read(String eventId){
            for (EventAppointment c: eventAppointmentDB) {
                if (c.getEventId().equals(eventId)){
                    return c;
                }

            }
            return null;
        }
        @Override
        public EventAppointment update(EventAppointment eventappointment) {
            EventAppointment firstEventAppointment = read(eventappointment.getEventId());
            if( firstEventAppointment !=null) {
                eventAppointmentDB.remove(firstEventAppointment);
                eventAppointmentDB.add(eventappointment);
                return eventappointment;
            }

            return null;
        }



        @Override
        public boolean delete(String eventID) {
            EventAppointment deleteEventAppointment = read(eventID);
            if (deleteEventAppointment ==null) {
                System.out.println("EventAppointment is null.");
            }
            eventAppointmentDB.remove(deleteEventAppointment);
            System.out.println("EventAppointment Removed.");
            return false;
        }
        @Override
        public Set<EventAppointment> getAll(){return eventAppointmentDB;}
    }


