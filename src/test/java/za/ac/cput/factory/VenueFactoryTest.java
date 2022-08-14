/* VenueFactoryTest.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.entity.Venue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VenueFactoryTest {

    @Test
    public void test(){
        Venue venue = VenueFactory.createVenue("CPT012", "Hotel Sky", 999, "Hotel");
        System.out.println(venue.toString());
        assertNotNull(venue);
    }
}
