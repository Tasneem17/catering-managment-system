package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.factory.BeverageMenuFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BeverageMenuControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private BeverageMenuController controller;
    @Autowired private TestRestTemplate restTemplate;
    private BeverageMenu beverageMenu;
    private String baseURL;



    @BeforeAll
    public void setUp() {
        assertNotNull(controller);
        this.beverageMenu = BeverageMenuFactory
                .createBeverageMenu("test-type","100","test-description","test-quantity","yes");
        System.out.println(this.beverageMenu);
        this.baseURL = "http://localhost:"+ this.port +"/catering/management/system/BeverageMenu/";
    }
    public static String SECURITY_USERNAME = "userA";
    public static String SECURITY_PASSWORD = "12345";
    @Order(1)
    @Test
    public void testSave() {
        String url = baseURL + "save/";
        System.out.println(url);
        ResponseEntity<BeverageMenu> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
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
        ResponseEntity<BeverageMenu> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url,BeverageMenu.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(3)
    public void testDelete() {
        String url = baseURL + "delete/"+ this.beverageMenu.getBeverageName();
        this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }

    @Test
    @Order(4)
    public void testFindAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<BeverageMenu> response =
                this.restTemplate
                        .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                        .getForEntity(url,BeverageMenu.class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)

        );
    }
}
