package za.ac.cput.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Appointment;
import za.ac.cput.entity.Category;
import za.ac.cput.entity.EventStatus;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentFactoryTest {

    @Test
    //Passing test
    public void test1(){
        Appointment apt = AppointmentFactory.build("001","1 January"
                ,"Camps Bay","16:00","645");
        System.out.println(apt.toString());
    }
    @Test
    @AfterEach
    //Failing Test
    public void test2() {
        Appointment apt = AppointmentFactory.build("001","1 January"
                ,"Camps Bay","0","fgfdhg");
        System.out.println(apt.toString());
    }
}