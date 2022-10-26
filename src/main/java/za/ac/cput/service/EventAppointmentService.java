package za.ac.cput.service;

import org.springframework.stereotype.Repository;
import za.ac.cput.entity.EventAppointment;
import za.ac.cput.service.IService;

import java.util.List;

//@Repository
public interface EventAppointmentService extends IService <EventAppointment, String>{

    boolean deletebyid(String id);

    List<EventAppointment> findAll();

}