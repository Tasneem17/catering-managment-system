/* VenueChoiceService.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service;

import za.ac.cput.entity.VenueChoice;
import java.util.Set;

public interface VenueChoiceService extends IService<VenueChoice, String>{
    public Set<VenueChoice> getAll();
}
