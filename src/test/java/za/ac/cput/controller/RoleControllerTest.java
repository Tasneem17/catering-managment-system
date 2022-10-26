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
import za.ac.cput.entity.Role;
import za.ac.cput.entity.User;
import za.ac.cput.factory.RoleFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RoleControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private RoleController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private Role role;
    private String baseURL;

    @BeforeAll
    public void setUp() {
        this.role = RoleFactory.createRole("87415889", "Manager", "Manages day to day functions");
        this.baseURL = "http://localhost:"+ this.port +"/role/";
    }
    public static String SECURITY_USERNAME = "userA";
    public static String SECURITY_PASSWORD = "12345";
    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<Role> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url,this.role,Role.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseURL + "read/"+ this.role.getRoleID();
        System.out.println(url);
        ResponseEntity<Role> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url,Role.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void deletebyId() {
        String url = baseURL + "delete/"+ this.role.getRoleID();
        this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }

    @Order(3)
    @Test
    void findAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<List<Role>> response =
                this.restTemplate
                        .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                        .exchange(
                                url,
                                HttpMethod.GET,
                                null,
                                new ParameterizedTypeReference<List<Role>>() {});
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode())
        );
    }
}