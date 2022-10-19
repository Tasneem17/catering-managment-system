/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 *Entity:EventTheme
 */


package za.ac.cput.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class EventTheme implements Serializable {

    @Id
    private String eventId;
    private String themeDescription;

    private EventTheme(Builder builder){
        this.eventId = builder.eventId;
        this.themeDescription = builder.themeDescription;
    }

    protected EventTheme(){}


    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getThemeDescription() {
        return themeDescription;
    }

    public void setThemeDescription(String themeDescription) {
        this.themeDescription = themeDescription;
    }

    @Override
    public String toString() {
        return "EventTheme{" +
                "eventId='" + eventId + '\'' +
                ", themeDescription='" + themeDescription + '\'' +
                '}';
    }

    public static class Builder{

        private String eventId;
        private String themeDescription;

        public Builder setEventId(String eventId){
            this.eventId = eventId;
            return this;
        }
        public Builder setThemeDescription(String themeDescription) {
            this.themeDescription = themeDescription;
            return this;
        }

        public Builder copy(EventTheme EventTheme){
            this.eventId =EventTheme.eventId;
            this.themeDescription = EventTheme.themeDescription;
            return this;
        }
        public EventTheme build(){
            return new EventTheme(this);


        }
    }
}
