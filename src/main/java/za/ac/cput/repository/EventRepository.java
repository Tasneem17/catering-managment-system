/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;

import org.hibernate.boot.JaccPermissionDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Event;

import java.util.List;
import java.util.Set;

public interface EventRepository extends JpaRepository<Event, String> {


    List<Event> findAll();
    Event findByEventId( String eventID);
}
