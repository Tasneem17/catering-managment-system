/* VenueChoiceServiceImpl.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.ContactType;
import za.ac.cput.entity.VenueChoice;
import za.ac.cput.repository.VenueChoiceRepository;
import za.ac.cput.service.VenueChoiceService;

import java.util.List;
import java.util.Optional;

@Service
public class VenueChoiceServiceImpl implements VenueChoiceService {
    private VenueChoiceRepository repository;

    @Autowired
    VenueChoiceServiceImpl(VenueChoiceRepository repository) {
        this.repository = repository;}

    public VenueChoice save(VenueChoice venueChoice) {
        return this.repository.save(venueChoice);}

    @Override
    public Optional<VenueChoice> read(String id) {
        return Optional.ofNullable(this.repository.findById(id).orElse(null));}

    @Override
    public void deleteById(String venueChoiceId){
        this.repository.deleteById(venueChoiceId);
    }


    @Override
    public List<VenueChoice> findAll() {
        return this.repository.findAll();
    }
}
