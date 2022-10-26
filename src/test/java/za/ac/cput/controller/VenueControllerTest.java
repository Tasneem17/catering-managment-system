/* VenueControllerTest.java
 Author: Chad Siegelaar (218340982)
 Date: October 2022
*/

package za.ac.cput.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.entity.Venue;
import za.ac.cput.factory.VenueFactory;

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
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<Venue> response = this.restTemplate
                .postForEntity(url,this.venue,Venue.class);
        System.out.println(response);
        assertAll(()->assertNotEquals(HttpStatus.OK,response.getStatusCode()), ()->assertNotNull(response.getBody()));
        System.out.println(response.getStatusCode());
    }

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

    @Test
    void read() {
        String url = baseURL + "read/"+ this.venue.getVenueId();
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Venue> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Venue> response = restTemplate.exchange(url, HttpMethod.GET, entity, Venue.class);
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void deleteById() {
        String url = baseURL + "delete/"+ this.venue.getVenueId();
        this.restTemplate.delete(url);
        System.out.println("Deleted:" + this.venue.getVenueId()+"\n"+url);
    }
}
