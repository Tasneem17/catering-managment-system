/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;

import za.ac.cput.entity.Event;

import java.util.Set;

public interface IEventRepository extends IRepository<Event, String> {


    public Set<Event> getAll();
}
