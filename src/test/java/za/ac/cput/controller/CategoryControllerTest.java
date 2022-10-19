package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.entity.Category;
import za.ac.cput.factory.CategoryFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryControllerTest {

@Autowired
private TestRestTemplate restTemplate;
@Autowired
private  CategoryController controller;
private Category category;
@LocalServerPort
private  int port;
private  String baseURL;
    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.category = CategoryFactory.createCategory("545","Breakfast","Kids sweet food");
        this.baseURL = "http://localhost:"+ this.port +"/category/";
    }
    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<Category> response = this.restTemplate.postForEntity(url,this.category,Category.class);
        System.out.println(response);
        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody()));
        System.out.println("Created: " + response.getBody());
    }
    @Order(4)
    @Test
    void delete() {
        String url = baseURL + "delete/"+ this.category.getCategory_ID();
        this.restTemplate.delete(url);
        System.out.println("Deleted:" + this.category.getCategory_ID()+"\n"+url);
    }
    @Order(3)
    @Test
    void findAll() {
        String url = baseURL + "all/" ;
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
        String url = baseURL + "read/"+ this.category.getCategory_ID();
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Category> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Category> response = restTemplate.exchange(url, HttpMethod.GET, entity, Category.class);
        System.out.println("Read: " + response.getBody());
    }
}