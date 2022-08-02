/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EventTheme;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class EventThemeFactoryTest {
    @Test

    void createEvent(){
        EventTheme eventTheme = EventThemeFactory.createEvent("no26","Denim Party");
        assertNotNull(eventTheme);
        System.out.println(eventTheme);
    }

}







