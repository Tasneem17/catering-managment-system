/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;

import za.ac.cput.entity.EventAppointment;

import java.util.Set;

public interface IEventAppointmentRepository extends IRepository<EventAppointment, String> {


    public Set<EventAppointment> getAll();
}
