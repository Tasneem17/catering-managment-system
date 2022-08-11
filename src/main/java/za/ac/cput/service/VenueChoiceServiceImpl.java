/* VenueChoiceServiceImpl.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.VenueChoice;
import za.ac.cput.repository.VenueChoiceRepository;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VenueChoiceServiceImpl implements VenueChoiceService {
    private VenueChoiceRepository repository;

    @Autowired
    VenueChoiceServiceImpl(VenueChoiceRepository repository) {
        this.repository = repository;}

    @Override
    public VenueChoice save(VenueChoice venueChoice) {
        return this.repository.save(venueChoice);}

    @Override
    public VenueChoice read(String id) {
        return this.repository.findById(id).orElse(null);}

    @Override
    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<VenueChoice> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
