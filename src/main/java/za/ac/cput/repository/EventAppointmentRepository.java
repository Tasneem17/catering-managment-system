/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.EventAppointment;
import za.ac.cput.entity.UserContact;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface EventAppointmentRepository extends JpaRepository<EventAppointment, String> {

//    List<EventAppointment> findAll();
//
//    EventAppointment findByEventAppointmentId(String EventAppointmentID);
//
//    void deleteUserContactByEventAppointmentID(String EventAppointmentID);
//
//    Optional<EventAppointment> findByFirstName(String firstname);
}