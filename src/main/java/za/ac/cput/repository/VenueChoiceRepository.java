/* VenueChoiceRepository.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.VenueChoice;
import java.util.Set;

@Repository
public interface VenueChoiceRepository extends JpaRepository<VenueChoice,String>{
    public Set<VenueChoice> getAll();
}
