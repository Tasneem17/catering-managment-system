package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.RoleFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoleControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private RoleController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private Role role;
    private String baseURL;

    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.role = RoleFactory.createRole("87415889", "Manager", "Manages day to day functions");
        this.baseURL = "http://localhost:"+ this.port +"/role/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<Role> response = this.restTemplate
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
        ResponseEntity<Role> response = this.restTemplate.getForEntity(url,Role.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void deletebyId() {
        String url = baseURL + "delete/"+ this.role.getRoleID();
        this.restTemplate.delete(url);
    }

    @Order(3)
    @Test
    void findAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<Role> response =
                this.restTemplate.getForEntity(url,Role.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode())
        );
    }
}