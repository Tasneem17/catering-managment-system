package za.ac.cput.factory.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.controller.EventStatusController;
import za.ac.cput.entity.EventStatus;
import za.ac.cput.factory.EventStatusFactory;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventStatusControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private EventStatusController controller;
    @Autowired private TestRestTemplate restTemplate;
    private EventStatus eventStatus;
    private String baseURL;

    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.eventStatus = EventStatusFactory
                .build("001","Available");
        this.baseURL = "http://;localhost:"+ this.port +"/catering/EventStatus-type/";
    }
    @Order(1)
    public void testSave() {
        String url = baseURL + "read/";
        System.out.println(url);
        ResponseEntity<EventStatus> response = this.restTemplate
                .postForEntity(url,this.eventStatus,EventStatus.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(2)

    public void testRead() {
        String url = baseURL + "read/"+ this.eventStatus.getEvent_id();
        System.out.println(url);
        ResponseEntity<EventStatus> response = this.restTemplate.getForEntity(url,EventStatus.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(3)
    public void testDelete() {
        String url = baseURL + "read/"+ this.eventStatus.getEvent_id();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    public void testFindAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<EventStatus> response =
                this.restTemplate.getForEntity(url,EventStatus.class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)

        );
    }
}
