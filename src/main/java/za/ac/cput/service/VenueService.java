/* VenueService.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service;

import za.ac.cput.entity.Venue;
import java.util.Set;

public interface VenueService extends IService<Venue, String>{
    public Set<Venue> getAll();
}
