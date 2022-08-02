/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */


package za.ac.cput.repository;

import za.ac.cput.entity.EventTheme;

import java.util.Set;

public interface IEventThemeRepository extends IRepository<EventTheme, String> {


    public Set<EventTheme> getAll();
}
