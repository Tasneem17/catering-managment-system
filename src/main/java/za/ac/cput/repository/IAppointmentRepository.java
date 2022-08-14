package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Appointment;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment,String> {

    //create,read,update ,delete
    public Set<Appointment> getAll();


    Optional<Appointment> read(String appointment);
}
