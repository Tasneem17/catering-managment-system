package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private UserController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private User user;
    private String baseURL;

    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.user = UserFactory.createUser("220003033","Wilbur","Smith");
        this.baseURL = "http://localhost:"+ this.port +"/user/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<User> response = this.restTemplate
                .postForEntity(url,this.user,User.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseURL + "read/"+ this.user.getUserID();
        System.out.println(url);
        ResponseEntity<User> response = this.restTemplate.getForEntity(url,User.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void deletebyId() {
        String url = baseURL + "delete/"+ this.user.getUserID();
        this.restTemplate.delete(url);
    }

    @Order(3)
    @Test
    void findAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<User> response =
                this.restTemplate.getForEntity(url,User.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode())
        );
    }
}