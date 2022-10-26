package za.ac.cput.controller;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Decor;
import za.ac.cput.factory.DecorFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DecorControllerTest {


    @LocalServerPort
    private int port;
    @Autowired
    private DecorController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Decor decor;
    private String baseURL;

    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.decor = DecorFactory
                .createDecor("test-type","","","");
        this.baseURL = "http://;localhost:"+ this.port +"/catering/decor-type/";
    }
    @Order(1)
    public void testSave() {
        String url = baseURL + "read/";
        System.out.println(url);
        ResponseEntity<Decor> response = this.restTemplate
                .postForEntity(url,this.decor,Decor.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(2)

    public void testRead() {
        String url = baseURL + "read/"+ this.decor.getDecorType();
        System.out.println(url);
        ResponseEntity<Decor> response = this.restTemplate.getForEntity(url,Decor.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(3)
    public void testDelete() {
        String url = baseURL + "read/"+ this.decor.getDecorType();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    public void testFindAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<Decor> response =
                this.restTemplate.getForEntity(url,Decor.class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)

        );
    }
}
