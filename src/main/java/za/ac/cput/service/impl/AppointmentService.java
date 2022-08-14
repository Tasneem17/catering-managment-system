package za.ac.cput.service.impl;

import za.ac.cput.entity.Appointment;
import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.service.IService;

import java.util.List;

public interface AppointmentService extends IService<Appointment,String> {

    List<Appointment> findAllAppointment_id(String appointment);
}
