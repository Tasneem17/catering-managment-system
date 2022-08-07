/* VenueRepository.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Venue;
import java.util.Set;

@Repository
public interface VenueRepository extends JpaRepository<Venue, String> {
    public Set<Venue> getAll();
}
