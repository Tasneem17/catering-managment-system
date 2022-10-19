package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.entity.Food;
import za.ac.cput.entity.Menu;
import za.ac.cput.factory.MenuFactory;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MenuControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private  MenuController controller;
    private Menu menu;
    @LocalServerPort
    private  int port;
    private  String baseURL;
    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.menu = MenuFactory.createMenu("787","8",520.50);

        this.baseURL = "http://localhost:"+ this.port +"/menu/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<Menu> response = this.restTemplate
                .postForEntity(url,this.menu,Menu.class);
        System.out.println(response);
        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody()));
        System.out.println(response.getStatusCode());

    }
    @Order(4)
    @Test
    void delete() {
        String url = baseURL + "delete/"+ this.menu.getMenu_ID();
        this.restTemplate.delete(url);
        System.out.println("Deleted:" + this.menu.getMenu_ID() +"\n"+url);
    }
    @Order(3)
    @Test
    void findAll() {
        String url = baseURL + "all/" ;
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = this.restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()));
        System.out.println(response.getBody());

    }
    @Order(2)
    @Test
    void read() {
        String url = baseURL + "read/"+ this.menu.getMenu_ID();
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        HttpEntity<Menu> entity = new HttpEntity<>(null, header);
        ResponseEntity<Menu> response = this.restTemplate.exchange(url,HttpMethod.GET,entity,Menu.class);
//        assertAll(()->assertEquals(HttpStatus.OK,response.getStatusCode()));
        System.out.println(response.getBody());
    }
}