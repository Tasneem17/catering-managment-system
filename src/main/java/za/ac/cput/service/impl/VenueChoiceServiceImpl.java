/* VenueChoiceServiceImpl.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.VenueChoice;
import za.ac.cput.repository.VenueChoiceRepository;
import za.ac.cput.service.VenueChoiceService;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public  class VenueChoiceServiceImpl implements VenueChoiceService {
    private VenueChoiceRepository repository;

    @Autowired
    VenueChoiceServiceImpl(VenueChoiceRepository repository) {
        this.repository = repository;}


    public VenueChoice save(VenueChoice venueChoice) {
        return this.repository.save(venueChoice);}


    public Optional<VenueChoice> read(String id) {
        return Optional.ofNullable(this.repository.findById(id).orElse(null));}


    public boolean deleteById(String venueChoice){
        this.repository.deleteById(venueChoice);
        return false;
    }

    @Override
    public Set<VenueChoice> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
