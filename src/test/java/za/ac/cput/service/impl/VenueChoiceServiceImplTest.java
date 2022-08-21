/* VenueChoiceServiceImplTest.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.VenueChoice;
import za.ac.cput.factory.VenueChoiceFactory;
import java.util.Optional;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class VenueChoiceServiceImplTest {
    @Autowired
    private VenueChoiceServiceImpl venueChoiceService;
    private VenueChoice venueChoice1;
    private VenueChoice venueChoice2;

    @Test
    @Order(1)
    void setUp() {
        venueChoice1 = VenueChoiceFactory.createVenueChoice("CPT05", "Bar");
        assertNotNull(venueChoice1);
        System.out.println(venueChoice1);
        venueChoice2 = VenueChoiceFactory.createVenueChoice("JHB02", "Hotel");
        assertNotNull(venueChoice2);
        System.out.println(venueChoice2);
    }

    @Test
    @Order(2)
    void save() {
        VenueChoice created1 = venueChoiceService.save(venueChoice1);
        assertNotNull(created1);
        System.out.println("created:" + created1);
        VenueChoice created2 = venueChoiceService.save(venueChoice2);
        assertNotNull(created2);
        System.out.println("created:" + created2);
    }

    @Test
    @Order(3)
    void read() {
        Optional<VenueChoice> read = venueChoiceService.read(venueChoice1.getVenueId());
        assertEquals(read.get(), venueChoice1.getVenueId());
        System.out.println("Read:" + read);
    }

    @Test
    @Order(5)
    void delete() {
        boolean success = venueChoiceService.delete(this.venueChoice2);
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println("Get All:");
        System.out.println(venueChoiceService.getAll());
    }
}
