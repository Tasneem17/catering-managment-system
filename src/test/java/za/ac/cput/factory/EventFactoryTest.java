/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Event;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class EventFactoryTest {
    @Test

    void createEvent(){
        Event event = EventFactory.createEvent("No13","DanielsWedding","Wedding","4Hrs");
        assertNotNull(event);
        System.out.println(event);
    }

}












