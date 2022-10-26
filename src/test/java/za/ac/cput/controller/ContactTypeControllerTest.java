/* ContactTypeControllerTest.java
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
import za.ac.cput.factory.ContactTypeFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ContactTypeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private  ContactTypeController controller;
    private ContactType contactType;
    @LocalServerPort
    private  int port;
    private  String baseURL;
    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.contactType = ContactTypeFactory.build("223", "John Smith", "Customer");
        this.baseURL = "http://localhost:"+ this.port +"/contactType/";
    }
    public static String SECURITY_USERNAME = "userA";
    public static String SECURITY_PASSWORD = "12345";
    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<ContactType> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url,this.contactType,ContactType.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }

    @Test
    void findAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<List<ContactType>> response =
                this.restTemplate
                        .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                        .exchange(url,
                                HttpMethod.GET,
                                null,
                                new ParameterizedTypeReference<List<ContactType>>() {});
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseURL + "read/"+ this.contactType.getContactTypeId();
        System.out.println(url);
        ResponseEntity<UserRole> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url,UserRole.class);
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void delete() {
        String url = baseURL + "delete/"+ this.contactType.getContactTypeId();
        this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }
}
