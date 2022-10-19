package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.EventStatus;

@Repository
public interface EventStatusRepository extends JpaRepository<EventStatus,String> {

}
