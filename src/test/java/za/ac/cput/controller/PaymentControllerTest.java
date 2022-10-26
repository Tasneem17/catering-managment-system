package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.entity.Payment;
import za.ac.cput.factory.AppointmentFactory;
import za.ac.cput.factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private  PaymentController controller;
    private Payment payment;
    @LocalServerPort
    private  int port;
    private  String baseURL;
    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.payment = PaymentFactory.build("001","1 January","Camps Bay");
        this.baseURL = "http://localhost:"+ this.port +"/Payment/";
    }
    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<Payment> response = this.restTemplate.postForEntity(url,this.payment,Payment.class);
        System.out.println(response);
        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody()));
        System.out.println("Created: " + response.getBody());
    }
    @Order(4)
    @Test
    void delete() {
        String url = baseURL + "/delete/"+ this.payment.getPayment_id();
        this.restTemplate.delete(url);
        System.out.println("Deleted:" + this.payment.getPayment_id()+"\n"+url);
    }
    @Order(3)
    @Test
    void findAll() {
        String url = baseURL + "/all/" ;
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        assertNotNull(response);
        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()));
        System.out.println(response.getBody());
    }
    @Order(2)
    @Test
    void read() {
        String url = baseURL + "/read/"+ this.payment.getPayment_id();
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Payment> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Payment> response = restTemplate.exchange(url, HttpMethod.GET, entity, Payment.class);
        System.out.println("Read: " + response.getBody());
    }
}