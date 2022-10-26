package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Appointment;
import za.ac.cput.repository.AppointmentRepository;
import za.ac.cput.service.AppointmentService;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceimpl implements AppointmentService {
    private  AppointmentRepository appointmentRepository;
    @Autowired
    public AppointmentServiceimpl(AppointmentRepository appointmentRepository) {this.appointmentRepository = appointmentRepository;}

    @Override
    public Appointment save(Appointment appointment) {return this.appointmentRepository.save(appointment);}

    @Override
    public Optional<Appointment> read(String s) {return this.appointmentRepository.findById(s);}

    @Override
    public boolean deleteById(String id) {
        this.appointmentRepository.deleteById(id);
        return false;
    }


    @Override
    public List<Appointment> findAll() {return this.appointmentRepository.findAll();}
}