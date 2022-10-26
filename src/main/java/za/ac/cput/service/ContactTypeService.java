/* ContactTypeService.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service;

import za.ac.cput.entity.ContactType;

import java.util.List;
import java.util.Optional;


public interface ContactTypeService{
    public List<ContactType> findAll();
    void deleteById(String contactTypeId);
    Optional<ContactType> read(String id);

}
