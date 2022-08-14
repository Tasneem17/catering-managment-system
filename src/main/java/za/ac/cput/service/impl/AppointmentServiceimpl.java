package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Appointment;
import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.repository.IAppointmentRepository;


import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceimpl implements AppointmentService{
    private final IAppointmentRepository repository;
    public AppointmentServiceimpl(IAppointmentRepository repository){
        this.repository = repository;
    }
    @Override
    public Appointment save (Appointment appointment){
        return this.repository.save(appointment);
    }
    @Override
    public Optional<Appointment> read(String appointment) {
        return this.repository.read(appointment);
    }
    @Override
    public void delete(Appointment appointment){
        this.repository.delete(appointment);
    }

    @Override
    public List<Appointment> findAllAppointment_id(String appointment) {
        return this.repository.findAll();
    }
}