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
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private UserController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private User user;
    private String baseURL;

    @BeforeAll
    public void setUp() {
        assertNotNull(controller);
        this.user = UserFactory.createUser("220003033","Wilbur","Smith");
        this.baseURL = "http://localhost:"+ this.port +"/user/";
    }
    public static String SECURITY_USERNAME = "userA";
    public static String SECURITY_PASSWORD = "12345";

    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<User> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url,this.user,User.class);
        System.out.println(response);
        System.out.println(this.user.getUserID());
        assertAll(
                    ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                    ()->assertNotNull(response.getBody()
                )
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseURL + "read/"+ this.user.getUserID();
        System.out.println("ID:" + this.user.getUserID());
        ResponseEntity<User> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url,User.class);
        System.out.println("Response: " + response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void deletebyId() {
        String url = baseURL + "delete/"+ this.user.getUserID();
        System.out.println("ID:" + this.user.getUserID());
        this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }

    @Order(3)
    @Test
    void findAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<List<User>> response =
                this.restTemplate
                    .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                    .exchange(
                            url,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<User>>() {});
        System.out.println("Response: " + response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode())
        );
    }
}