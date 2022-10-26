/* VenueChoiceControllerTest.java
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
import za.ac.cput.entity.ContactType;
import za.ac.cput.entity.UserRole;
import za.ac.cput.entity.VenueChoice;
import za.ac.cput.factory.VenueChoiceFactory;

import java.util.List;

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

    public static String SECURITY_USERNAME = "userA";
    public static String SECURITY_PASSWORD = "12345";

    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<VenueChoice> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url,this.venueChoice,VenueChoice.class);
        System.out.println(response);
        assertAll(
                ()->assertNotNull(response.getBody())
        );
    }

    @Test
    void findAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<List<VenueChoice>> response =
                this.restTemplate
                        .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                        .getForEntity(url,
                                null,
                                new ParameterizedTypeReference<List<VenueChoice>>() {});
        assertAll(
                ()->assertNotEquals(HttpStatus.OK,response.getStatusCode())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseURL + "read/"+ this.venueChoice.getVenueId();
        System.out.println(url);
        ResponseEntity<VenueChoice> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url,VenueChoice.class);
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void delete() {
        String url = baseURL + "delete/"+ this.venueChoice.getVenueId();
        this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }
}
