/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 *Entity:eventAppointment
 */

package za.ac.cput.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class EventAppointment implements Serializable {

    @Id
    private String eventId;

    private String appointmentId;

    private EventAppointment(Builder builder) {
        this.eventId = builder.eventId;
        this.appointmentId = builder.appointmentId;
    }
    protected EventAppointment(){}

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appoinmentId) {
        this.appointmentId = appoinmentId;

    }

    @Override
    public String toString() {
        return "eventAppointment{" +
                "eventId='" + eventId + '\'' +
                ", appointmentId='" + appointmentId + '\'' +
                '}';
    }

    public static class Builder{

        private String eventId;
        private String appointmentId;

        public Builder setEventId(String eventId){
            this.eventId = eventId;
            return this;
        }
        public Builder setAppointmentId(String appointmentId) {
            this.appointmentId = appointmentId;
            return this;

        }

        public Builder copy(EventAppointment eventAppointment){
            this.eventId =eventAppointment.eventId;
            this.appointmentId = eventAppointment.appointmentId;
            return this;
        }
        public EventAppointment build(){
            return new EventAppointment(this);


        }
    }
}
