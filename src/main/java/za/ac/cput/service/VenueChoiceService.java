/* VenueChoiceService.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service;


import za.ac.cput.entity.VenueChoice;

import java.util.List;
import java.util.Optional;

public interface VenueChoiceService {
    public List<VenueChoice> findAll();
    void deleteById(String venueChoiceId);
    Optional<VenueChoice> read(String id);

}
