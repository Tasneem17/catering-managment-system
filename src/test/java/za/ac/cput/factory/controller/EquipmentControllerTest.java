package za.ac.cput.factory.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.controller.EquipmentController;
import za.ac.cput.entity.Equipment;
import za.ac.cput.factory.EquipmentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EquipmentControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private EquipmentController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Equipment equipment;
    private String baseURL;


    @BeforeEach
    public void setUp() {
        assertNotNull(controller);
        this.equipment = EquipmentFactory
                .createEquipment("test-type","","","");
        this.baseURL = "http://;localhost:"+ this.port +"/catering/Equipment-type/";
    }
    @Order(1)
    public void testSave() {
        String url = baseURL + "read/";
        System.out.println(url);
        ResponseEntity<Equipment> response = this.restTemplate
                .postForEntity(url,this.equipment,Equipment.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(2)

    public void testRead() {
        String url = baseURL + "read/"+ this.equipment.getEquipmentID();
        System.out.println(url);
        ResponseEntity<Equipment> response = this.restTemplate.getForEntity(url,Equipment.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(3)
    public void testDelete() {
        String url = baseURL + "read/"+ this.equipment.getEquipmentID();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    public void testFindAll() {
        String url = baseURL + "all" ;
        System.out.println(url);
        ResponseEntity<Equipment> response =
                this.restTemplate.getForEntity(url,Equipment.class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)

        );
    }
}
