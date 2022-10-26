package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.EquipmentChoice;
import za.ac.cput.factory.EquipmentChoiceFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EquipmentChoiceControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private EquipmentController controller;
    @Autowired private TestRestTemplate restTemplate;
    private EquipmentChoice equipmentChoice;
    private String baseURL;


    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.equipmentChoice = EquipmentChoiceFactory
                .createEquipmentChoice("test-type","");
        this.baseURL = "http://;localhost:"+ this.port +"/catering/EquipmentChoice-type/";
    }
    @Order(1)
    public void testSave() {
        String url = baseURL + "read/";
        System.out.println(url);
        ResponseEntity<EquipmentChoice> response = this.restTemplate
                .postForEntity(url,this.equipmentChoice,EquipmentChoice.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(2)

    public void testRead() {
        String url = baseURL + "read/"+ this.equipmentChoice.getChoiceCustomer();
        System.out.println(url);
        ResponseEntity<EquipmentChoice> response = this.restTemplate.getForEntity(url,EquipmentChoice.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(3)
    public void testDelete() {
        String url = baseURL + "read/"+ this.equipmentChoice.getChoiceCustomer();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    public void testFindAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<EquipmentChoice> response =
                this.restTemplate.getForEntity(url,EquipmentChoice.class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)

        );
    }
}
