/* VenueControllerTest.java
 Author: Chad Siegelaar (218340982)
 Date: October 2022
*/

package za.ac.cput.controller;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import za.ac.cput.entity.Venue;
import za.ac.cput.entity.VenueChoice;
import za.ac.cput.factory.VenueFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class VenueControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private  VenueController controller;
    private Venue venue;
    @LocalServerPort
    private  int port;
    private  String baseURL;
    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.venue = VenueFactory.build("CPT05", "Casey's Bar", 3500.00,"Bachelor party");
        this.baseURL = "http://localhost:"+ this.port +"/venue/";
    }
    public static String SECURITY_USERNAME = "userA";
    public static String SECURITY_PASSWORD = "12345";
    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<Venue> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url,this.venue,Venue.class);
        System.out.println(response);
        assertAll(
                ()->assertNotNull(response.getBody())
        );
    }

    @Test
    void findAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<List<Venue>> response =
                this.restTemplate
                        .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                        .getForEntity(url,
                                null,
                                new ParameterizedTypeReference<List<Venue>>() {});
    }

    @Order(2)
    @Test
    void read() {
        String url = baseURL + "read/"+ this.venue.getVenueId();
        System.out.println(url);
        ResponseEntity<Venue> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url,Venue.class);
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void delete() {
        String url = baseURL + "delete/"+ this.venue.getVenueId();
        this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }
}
