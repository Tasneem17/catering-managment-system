package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.entity.Food;
import za.ac.cput.factory.FoodFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FoodControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private  FoodController controller;
    private Food food;
    @LocalServerPort
    private  int port;

    public static String SECURITY_USERNAME = "userA";
    public static String SECURITY_PASSWORD = "12345";
    private  String baseURL;
    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.food = FoodFactory.createFood("111","Bread","Brown","8 Loaf",
                400.00);
      //  this.food1 = FoodFactory.createFood("111","Bread","Brown","8 Loaf",
            //    400.00);
        this.baseURL = "http://localhost:"+ this.port +"/food/";
    }
//     private static Food food1=  FoodFactory.createFood("345","xxx","aaa","ddd",44.44);

    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<Food> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url, this.food,Food.class);
        System.out.println(response);
        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody()));

        System.out.println(response.getBody());
    }
    @Order(4)
    @Test
    void delete() {
        String url = baseURL + "delete/"+ this.food.getFood_ID();
        this.restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .delete(url);
        System.out.println("Deleted:" + this.food.getFood_ID() +"\nAt "+url);
    }
    @Order(2)
    @Test
    void findAll() {
        String url = baseURL + "all/" ;
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET,entity,String.class);
        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()));
        System.out.println(response.getBody());
    }
    @Order(3)
    @Test
    void read() {
        String url = baseURL + "read/"+ this.food.getFood_ID();
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Food> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Food> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, Food.class);
//        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()));
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }
}