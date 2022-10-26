/* VenueAddressControllerTest.java
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
import za.ac.cput.entity.VenueAddress;
import za.ac.cput.factory.VenueAddressFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class VenueAddressControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private  VenueAddressController controller;
    private VenueAddress venueAddress;
    @LocalServerPort
    private  int port;
    private  String baseURL;
    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.venueAddress = VenueAddressFactory.build("Claremont", "Cape Town", "Main Street");
        this.baseURL = "http://localhost:"+ this.port +"/venueAddress/";
    }
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<VenueAddress> response = this.restTemplate.postForEntity(url,this.venueAddress,VenueAddress.class);
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
        String url = baseURL + "read/"+ this.venueAddress.getVenueAddressArea();
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<VenueAddress> entity = new HttpEntity<>(null, headers);
        ResponseEntity<VenueAddress> response = restTemplate.exchange(url, HttpMethod.GET, entity, VenueAddress.class);
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void deleteById() {
        String url = baseURL + "delete/"+ this.venueAddress.getVenueAddressArea();
        this.restTemplate.delete(url);
        System.out.println("Deleted:" + this.venueAddress.getVenueAddressArea()+"\n"+url);
    }
}
