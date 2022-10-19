package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.entity.EventStatus;

import static org.junit.jupiter.api.Assertions.*;

class EventStatusFactoryTest {

    @Test
    public void buildWithSuccess() {

        EventStatus eventStatus = EventStatusFactory
                .build("001","active");
        System.out.println(eventStatus);
        assertNotNull(eventStatus);
    }

    @Test
    public void buildWithError() {

        Exception  exception = assertThrows(IllegalArgumentException.class,() ->
                EventStatusFactory
                        .build("null",""));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame( "event ID is required!",exceptionMessage );
    }
}