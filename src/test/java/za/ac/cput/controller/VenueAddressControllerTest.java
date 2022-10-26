/* VenueAddressControllerTest.java
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
import za.ac.cput.entity.VenueAddress;
import za.ac.cput.factory.VenueAddressFactory;

import java.util.List;

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
    public static String SECURITY_USERNAME = "userA";
    public static String SECURITY_PASSWORD = "12345";
    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<VenueAddress> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url,this.venueAddress,VenueAddress.class);
        System.out.println(response);
        assertAll(
                ()->assertNotNull(response.getBody())
        );
    }

    @Test
    void findAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<List<VenueAddress>> response =
                this.restTemplate
                        .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                        .getForEntity(url,
                                null,
                                new ParameterizedTypeReference<List<VenueAddress>>() {});
    }

    @Order(2)
    @Test
    void read() {
        String url = baseURL + "read/"+ this.venueAddress.getVenueAddressArea();
        System.out.println(url);
        ResponseEntity<VenueAddress> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url,VenueAddress.class);
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void delete() {
        String url = baseURL + "delete/"+ this.venueAddress.getVenueAddressArea();
        this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }
}
