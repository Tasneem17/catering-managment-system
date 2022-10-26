package za.ac.cput.factory.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.controller.PaymentController;
import za.ac.cput.entity.EventStatus;
import za.ac.cput.entity.Payment;
import za.ac.cput.factory.EventStatusFactory;
import za.ac.cput.factory.PaymentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaymentControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private PaymentController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Payment payment;
    private String baseURL;

    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.payment = PaymentFactory
                .build("001","Available","");
        this.baseURL = "http://;localhost:"+ this.port +"/catering/EventStatus-type/";
    }
    @Order(1)
    public void testSave() {
        String url = baseURL + "read/";
        System.out.println(url);
        ResponseEntity<Payment> response = this.restTemplate
                .postForEntity(url,this.payment,Payment.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(2)

    public void testRead() {
        String url = baseURL + "read/"+ this.payment.getPayment_id();
        System.out.println(url);
        ResponseEntity<Payment> response = this.restTemplate.getForEntity(url,Payment.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(3)
    public void testDelete() {
        String url = baseURL + "read/"+ this.payment.getPayment_id();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    public void testFindAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<Payment> response =
                this.restTemplate.getForEntity(url,Payment.class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)

        );
    }
}

