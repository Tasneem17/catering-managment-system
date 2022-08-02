/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 *Entity:Event
 */

package za.ac.cput.entity;


public class Event {
    private String eventId;
    private String eventName;
    private String eventDescription;
    private String eventDuration;

    private Event(Builder builder){
        this.eventId = builder.eventId;
        this.eventName = builder.eventName;
        this.eventDescription = builder.eventDescription;
        this.eventDuration = builder.eventDuration;


    }
    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventDuration() {
        return eventDuration;
    }

    public void setEventDuration(String eventDuration) {
        this.eventDuration = eventDuration;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventDuration='" + eventDuration + '\'' +
                '}';
    }

    public static class Builder{

        private String eventId;
        private String eventName;
        private String eventDescription;
        private String eventDuration;

        public Builder setEventId(String eventId){
            this.eventId = eventId;
            return this;
        }
        public Builder setEventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        public Builder setEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
            return this;
        }

        public Builder setEventDuration(String eventDuration){
            this.eventDuration = eventDuration;
            return this;
        }

        public Builder copy(Event eventTheme ){
            this.eventId =eventTheme .eventId;
            this.eventName = eventTheme .eventName;
            this.eventDescription = eventTheme .eventDescription;
            this.eventDuration = eventTheme .eventDuration;
            return this;
        }
        public Event build(){
            return new Event(this);


        }
    }
}
