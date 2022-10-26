/* VenueAddressFactoryTest.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.VenueAddress;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VenueAddressFactoryTest {

    @Test
    public void test1(){
        VenueAddress venueAddress = VenueAddressFactory.build("Rondebosch", "CapeTown", "3rd Avenue");
        System.out.println(venueAddress.toString());
        assertNotNull(venueAddress);
    }
}
