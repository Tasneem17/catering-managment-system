/* VenueChoiceFactoryTest.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.entity.VenueChoice;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VenueChoiceFactoryTest {

    @Test
    public void test1() {
        VenueChoice venueChoice = VenueChoiceFactory.build("081", "Birthday");
        System.out.println(venueChoice.toString());
        assertNotNull(venueChoice);
    }
}

