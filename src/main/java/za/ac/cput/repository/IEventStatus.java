package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.entity.EventStatus;

import java.util.Set;

public interface IEventStatus extends JpaRepository<EventStatus,String> {

    //create,read,update ,delete
    public Set<EventStatus> getAll();
}
