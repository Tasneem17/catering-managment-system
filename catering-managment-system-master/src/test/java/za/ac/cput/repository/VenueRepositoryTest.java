/* VenueRepositoryTest.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Venue;
import za.ac.cput.factory.VenueFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

public class VenueRepositoryTest {
    private static VenueRepository repository = VenueRepository.getRepository();
    private static Venue venue = VenueFactory.createVenue("Richards's", "Bar", (699), "Bar");

    @Test
    void l_create() {
        Venue created = repository.create(venue);
        assertEquals(venue.getVenueId(),created.getVenueId());
        System.out.println("Create: " + created);
    }

    @Test
    void n_update() {
        Venue updated = new Venue.Builder().copy(venue).setVenueId("056")
                .setVenueName("Jakarti")
                .setVenuePrice(799)
                .setVenueDescription("Restaurant")
                .build();
        System.out.println("Updated: "+ updated);
    }

    @Test
    void o_delete() {
        boolean success = repository.delete(venue.getVenueId());

        System.out.println("Delete" + success);
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}
