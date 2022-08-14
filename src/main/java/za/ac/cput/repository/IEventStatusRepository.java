package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.EventStatus;

import java.util.Optional;
import java.util.Set;
@Repository
public interface IEventStatusRepository extends JpaRepository<EventStatus,String> {

    //create,read,update ,delete
    public Set<EventStatus> getAll();

    Optional<EventStatus> read(String eventStatus);

}
