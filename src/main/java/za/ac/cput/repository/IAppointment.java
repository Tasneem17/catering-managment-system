package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Appointment;
import za.ac.cput.entity.BeverageMenu;

import java.util.Set;

public interface IAppointment extends JpaRepository<BeverageMenu,String> {

    //create,read,update ,delete
    public Set<Appointment> getAll();
}
