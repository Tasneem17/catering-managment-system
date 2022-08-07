/* VenueAddressRepositoryTest.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.VenueAddress;
import za.ac.cput.entity.VenueChoice;
import za.ac.cput.factory.VenueChoiceFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

public class VenueAddressRepositoryTest {
    private static VenueAddressRepository repository = VenueAddressRepository.getRepository();
    private static VenueAddress venueAddress = VenueAddressRepository.createVenueAddress("Rondebosch", "Cape Town", "3rd Avenue");

    @Test
    void l_create() {
        VenueAddress created = repository.create(venueAddress);
        assertEquals(venueAddress.getVenueAddressArea(),created.getVenueAddressArea());
        System.out.println("Create: " + created);
    }

    @Test
    void m_read() {
        VenueAddress read = repository.read(venueAddress.getVenueAddressArea());
        assertNotNull(read);
        System.out.println("Read :"+ read);
    }

    @Test
    void n_update() {
        VenueAddress updated = new VenueAddress.Builder().copy(venueAddress).setVenueAddressArea("Rondebosch")
                .setVenueAddressCity("Cape Town")
                .setVenueAddressStreet("3rd Avenue")
                .build();
        System.out.println("Updated: "+ updated);
    }

    @Test
    void o_delete() {
        boolean success = repository.delete(venueAddress.getVenueAddressArea());
        assertTrue(success);
        System.out.println("Delete" + success);
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}