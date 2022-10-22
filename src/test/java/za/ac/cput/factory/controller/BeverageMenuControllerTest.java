package za.ac.cput.factory.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.controller.BeverageMenuController;
import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.factory.BeverageMenuFactory;
import za.ac.cput.factory.DecorFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BeverageMenuControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private BeverageMenuController controller;
    @Autowired private TestRestTemplate restTemplate;
    private BeverageMenu beverageMenu;
    private String baseURL;

    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.beverageMenu = BeverageMenuFactory
                .createBeverageMenu("test-type","","","","");
        this.baseURL = "http://;localhost:"+ this.port +"/catering/Beverage-type/";
    }
    @Order(1)
    public void testSave() {
        String url = baseURL + "read/";
        System.out.println(url);
        ResponseEntity<BeverageMenu> response = this.restTemplate
                .postForEntity(url,this.beverageMenu,BeverageMenu.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(2)

    public void testRead() {
        String url = baseURL + "read/"+ this.beverageMenu.getBeverageName();
        System.out.println(url);
        ResponseEntity<BeverageMenu> response = this.restTemplate.getForEntity(url,BeverageMenu.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(3)
    public void testDelete() {
        String url = baseURL + "read/"+ this.beverageMenu.getBeverageName();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    public void testFindAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<BeverageMenu> response =
                this.restTemplate.getForEntity(url,BeverageMenu.class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)

        );
    }
}
