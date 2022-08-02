package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EventStatus;

import static org.junit.jupiter.api.Assertions.*;

class EventStatusFactoryTest {

    @Test
    public void test(){
        EventStatus eventStatus = EventStatusFactory.createEventStatus("001","active");
        assertNotNull(eventStatus);
        System.out.println(eventStatus);
    }

}