package za.ac.cput.factory.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.controller.EventStatusController;
import za.ac.cput.controller.UserPaymentController;
import za.ac.cput.entity.EventStatus;
import za.ac.cput.entity.UserPayment;
import za.ac.cput.factory.EventStatusFactory;
import za.ac.cput.factory.UserPaymentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserPaymentControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private UserPaymentController controller;
    @Autowired private TestRestTemplate restTemplate;
    private UserPayment userPayment;
    private String baseURL;

    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.userPayment = UserPaymentFactory
                .build("001","Available","R1000");
        this.baseURL = "http://;localhost:"+ this.port +"/catering/UserPayment-type/";
    }
    @Order(1)
    public void testSave() {
        String url = baseURL + "read/";
        System.out.println(url);
        ResponseEntity<UserPayment> response = this.restTemplate
                .postForEntity(url,this.userPayment,UserPayment.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(2)

    public void testRead() {
        String url = baseURL + "read/"+ this.userPayment.getId();
        System.out.println(url);
        ResponseEntity<UserPayment> response = this.restTemplate.getForEntity(url,UserPayment.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(3)
    public void testDelete() {
        String url = baseURL + "read/"+ this.userPayment.getId();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    public void testFindAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<UserPayment> response =
                this.restTemplate.getForEntity(url,UserPayment.class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)

        );
    }
}

