/* VenueChoiceControllerTest.java
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
import za.ac.cput.entity.VenueChoice;
import za.ac.cput.factory.VenueChoiceFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class VenueChoiceControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private  VenueChoiceController controller;
    private VenueChoice venueChoice;
    @LocalServerPort
    private  int port;
    private  String baseURL;
    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.venueChoice = VenueChoiceFactory.build("CPT05", "Bar");
        this.baseURL = "http://localhost:"+ this.port +"/venueChoice/";
    }
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<VenueChoice> response = this.restTemplate.postForEntity(url,this.venueChoice,VenueChoice.class);
        System.out.println(response);
        assertAll(()->assertNotEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody()));
        System.out.println("Created: " + response.getBody());
    }

    @Test
    void findAll() {
        String url = baseURL + "all/" ;
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        assertNotNull(response);
        assertAll(()->assertNotEquals(HttpStatus.OK,response.getStatusCode()));
        System.out.println(response.getBody());
    }

    @Test
    void read() {
        String url = baseURL + "read/"+ this.venueChoice.getVenueType();
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<VenueChoice> entity = new HttpEntity<>(null, headers);
        ResponseEntity<VenueChoice> response = restTemplate.exchange(url, HttpMethod.GET, entity, VenueChoice.class);
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void deleteById() {
        String url = baseURL + "delete/"+ this.venueChoice.getVenueType();
        this.restTemplate.delete(url);
        System.out.println("Deleted:" + this.venueChoice.getVenueType()+"\n"+url);
    }
}
