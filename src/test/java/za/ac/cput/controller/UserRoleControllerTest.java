package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.UserRole;
import za.ac.cput.factory.UserRoleFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRoleControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private UserRoleController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private UserRole userRole;
    private String baseURL;

    @BeforeAll
    public void setUp() {
        assertNotNull(controller);
        this.userRole = UserRoleFactory.createUserRole("220003033", "87415889");
        this.baseURL = "http://localhost:"+ this.port +"/user-role/";
    }
    public static String SECURITY_USERNAME = "userA";
    public static String SECURITY_PASSWORD = "12345";
    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<UserRole> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url,this.userRole,UserRole.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseURL + "read/"+ this.userRole.getUserID();
        System.out.println(url);
        ResponseEntity<UserRole> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url,UserRole.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseURL + "delete/"+ this.userRole.getUserID();
        this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }

    @Test
    void findAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<List<UserRole>> response =
                this.restTemplate
                        .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                                .exchange(url,
                                        HttpMethod.GET,
                                        null,
                                        new ParameterizedTypeReference<List<UserRole>>() {});
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode())
        );
    }
}