/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */


package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.EventTheme;


import java.util.List;
import java.util.Optional;


public interface EventThemeRepository extends JpaRepository<EventTheme, String> {

    List<EventTheme> findAll();

    EventTheme findByEventId(String EventThemeID);

    void deleteUserContactByEventID(String EventThemeID);

    Optional<EventTheme> findByFirstName(String firstname);
}