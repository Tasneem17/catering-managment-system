package za.ac.cput.service;

import za.ac.cput.entity.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    Appointment save(Appointment appointment);

    Optional<Appointment> read(String s);

    boolean deleteById(String id);

    List<Appointment> findAll();
}


