/* VenueAddressServiceImplTest.java
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
import za.ac.cput.entity.VenueAddress;
import za.ac.cput.factory.VenueAddressFactory;
import java.util.Optional;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class VenueAddressServiceImplTest {
    @Autowired
    private VenueAddressServiceImpl venueAddressService;
    private VenueAddress venueAddress1;
    private VenueAddress venueAddress2;

    @Test
    @Order(1)
    void setUp() {
        venueAddress1 = VenueAddressFactory.build("Claremont", "Cape Town", "Main Street");
        assertNotNull(venueAddress1);
        System.out.println(venueAddress1);
        venueAddress2 = VenueAddressFactory.build("Rosebank", "Johannesburg", "8th Street");
        assertNotNull(venueAddress2);
        System.out.println(venueAddress2);
    }

    @Test
    @Order(2)
    void save() {
        VenueAddress created1 = venueAddressService.save(venueAddress1);
        assertNotNull(created1);
        System.out.println("created:" + created1);
        VenueAddress created2 = venueAddressService.save(venueAddress2);
        assertNotNull(created2);
        System.out.println("created:" + created2);
    }

    @Test
    @Order(3)
    void read() {
        Optional<VenueAddress> read = venueAddressService.read(venueAddress1.getVenueAddressArea());
        assertEquals(read.get(), venueAddress1.getVenueAddressArea());
        System.out.println("Read:" + read);
    }

    @Test
    @Order(5)
    void deleteById() {
        this.venueAddressService.deleteById(String.valueOf(this.venueAddress2));
    }


    @Test
    @Order(4)
    void findAll() {
        System.out.println("Find All:");
        System.out.println(venueAddressService.findAll());
    }
}

