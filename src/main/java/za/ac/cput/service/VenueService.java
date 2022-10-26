/* VenueService.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service;


import za.ac.cput.entity.Venue;

import java.util.List;
import java.util.Optional;


public interface VenueService {
    public List<Venue> findAll();
    void deleteById(String venueId);
    Optional<Venue> read(String id);
}
