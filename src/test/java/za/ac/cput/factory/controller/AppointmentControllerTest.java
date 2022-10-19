package za.ac.cput.factory.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.controller.AppointmentController;
import za.ac.cput.entity.Appointment;
import za.ac.cput.factory.AppointmentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppointmentControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private AppointmentController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Appointment appointment;
    private String baseURL;

    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.appointment = AppointmentFactory
                .build("001","Available","","","");
        this.baseURL = "http://;localhost:"+ this.port +"/catering/EventStatus-type/";
    }
    @Order(1)
    public void testSave() {
        String url = baseURL + "read/";
        System.out.println(url);
        ResponseEntity<Appointment> response = this.restTemplate
                .postForEntity(url,this.appointment,Appointment.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(2)

    public void testRead() {
        String url = baseURL + "read/"+ this.appointment.getAppointment_id();
        System.out.println(url);
        ResponseEntity<Appointment> response = this.restTemplate.getForEntity(url,Appointment.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(3)
    public void testDelete() {
        String url = baseURL + "read/"+ this.appointment.getAppointment_id();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    public void testFindAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<Appointment> response =
                this.restTemplate.getForEntity(url,Appointment.class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)

        );
    }
}
