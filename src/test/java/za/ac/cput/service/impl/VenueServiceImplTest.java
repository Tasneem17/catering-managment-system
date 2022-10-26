/* VenueServiceImplTest.java
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
import za.ac.cput.entity.Venue;
import za.ac.cput.factory.VenueFactory;
import java.util.Optional;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class VenueServiceImplTest {
    @Autowired
    private VenueServiceImpl venueService;
    private Venue venue1;
    private Venue venue2;

    @Test
    @Order(1)
    void setUp() {
        venue1 = VenueFactory.build("CPT05", "Casey's Bar", 3500.00,"Bachelor party");
        assertNotNull(venue1);
        System.out.println(venue1);
        venue2 = VenueFactory.build("JHB02", "Sandy Beach Hotel", 5000.00, "Wedding");
        assertNotNull(venue2);
        System.out.println(venue2);
    }

    @Test
    @Order(2)
    void save() {
        Venue created1 = venueService.save(venue1);
        assertNotNull(created1);
        System.out.println("created:" + created1);
        Venue created2 = venueService.save(venue2);
        assertNotNull(created2);
        System.out.println("created:" + created2);
    }

    @Test
    @Order(3)
    void read() {
        Optional<Venue> read = venueService.read(venue1.getVenueId());
        assertEquals(read.get(), venue1.getVenueId());
        System.out.println("Read:" + read);
    }

    @Test
    @Order(5)
    void deleteById() {
        this.venueService.deleteById(String.valueOf(this.venue2));
    }

    @Test
    @Order(4)
    void findAll() {
        System.out.println("Find All:");
        System.out.println(venueService.findAll());
    }
}
