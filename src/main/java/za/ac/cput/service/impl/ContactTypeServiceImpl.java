/* ContactTypeServiceImpl.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.ContactType;
import za.ac.cput.repository.ContactTypeRepository;
import za.ac.cput.service.ContactTypeService;

import java.util.List;
import java.util.Optional;


@Service
public class ContactTypeServiceImpl implements ContactTypeService {
    private ContactTypeRepository repository;

    @Autowired
    public ContactTypeServiceImpl(ContactTypeRepository repository) {
        this.repository = repository;}


    public ContactType save(ContactType contactType) {
        return this.repository.save(contactType);}

    @Override
    public Optional<ContactType> read(String id) {
        return Optional.ofNullable(this.repository.findById(id).orElse(null));}

    @Override
    public void deleteById(String contactTypeId){
        this.repository.deleteById(contactTypeId);
    }

    @Override
    public List<ContactType> findAll() {
        return this.repository.findAll();
    }
}
