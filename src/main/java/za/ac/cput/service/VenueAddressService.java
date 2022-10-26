/* VenueAddressService.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service;

import za.ac.cput.entity.Venue;
import za.ac.cput.entity.VenueAddress;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface VenueAddressService{
    public List<VenueAddress> findAll();
    void deleteById(String venueAddressId);
    Optional<VenueAddress> read(String id);

}
