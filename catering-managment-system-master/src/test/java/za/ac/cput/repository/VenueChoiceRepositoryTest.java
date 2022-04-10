/* VenueChoiceRepositoryTest.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.VenueChoice;
import za.ac.cput.factory.VenueChoiceFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

public class VenueChoiceRepositoryTest {
    private static VenueChoiceRepository repository = VenueChoiceRepository.getRepository();
    private static VenueChoice venueChoice = VenueChoiceFactory.createVenueChoice("084","Graduation Party");

    @Test
    void l_create() {
        VenueChoice created = repository.create(venueChoice);
        assertEquals(venueChoice.getVenueId(),created.getVenueId());
        System.out.println("Create: " + created);
    }

    @Test
    void m_read() {
        VenueChoice read = repository.read(venueChoice.getVenueId());
        assertNotNull(read);
        System.out.println("Read :"+ read);
    }

    @Test
    void n_update() {
        VenueChoice updated = new VenueChoice.Builder().copy(venueChoice).setVenueId("011")
                .setVenueType("Dinner Party")
                .build();
        System.out.println("Updated: "+ updated);
    }

    @Test
    void o_delete() {
        boolean success = repository.delete(venueChoice.getVenueId());
        assertTrue(success);
        System.out.println("Delete" + success);
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}