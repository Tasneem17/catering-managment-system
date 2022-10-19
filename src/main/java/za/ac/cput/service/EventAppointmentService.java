package za.ac.cput.service;

import za.ac.cput.entity.EventAppointment;

import java.util.List;

public interface EventAppointmentService extends IService <EventAppointment, String>{

    List<EventAppointment> findAll();

}