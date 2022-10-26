package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.entity.Category;
import za.ac.cput.entity.EventStatus;
import za.ac.cput.factory.CategoryFactory;
import za.ac.cput.factory.EventStatusFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EventStatusControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private  EventStatusController controller;
    private EventStatus eventStatus;
    @LocalServerPort
    private  int port;
    private  String baseURL;
    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.eventStatus = EventStatusFactory.build("001", "Available");
        this.baseURL = "http://localhost:"+ this.port +"/eventStatus/";
    }
    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<EventStatus> response = this.restTemplate.postForEntity(url,this.eventStatus,EventStatus.class);
        System.out.println(response);
        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody()));
        System.out.println("Created: " + response.getBody());
    }
    @Order(4)
    @Test
    void deletebyId() {
        String url = baseURL + "delete/"+ this.eventStatus.getEvent_id();
        this.restTemplate.delete(url);
        System.out.println("Deleted:" + this.eventStatus.getEvent_id()+"\n"+url);
    }
    @Order(3)
    @Test
    void findAll() {
        String url = baseURL + "all/" ;
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        assertNotNull(response);
        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()));
        System.out.println(response.getBody());
    }
    @Order(2)
    @Test
    void read() {
        String url = baseURL + "read/"+ this.eventStatus.getEvent_id();
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<EventStatus> entity = new HttpEntity<>(null, headers);
        ResponseEntity<EventStatus> response = restTemplate.exchange(url, HttpMethod.GET, entity, EventStatus.class);
        System.out.println("Read: " + response.getBody());
    }
}