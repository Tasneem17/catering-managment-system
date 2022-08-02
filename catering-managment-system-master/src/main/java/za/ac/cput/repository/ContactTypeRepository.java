/* ContactTypeRepository.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.repository;

import za.ac.cput.entity.ContactType;
import java.util.HashSet;
import java.util.Set;

public class ContactTypeRepository {
    private static ContactTypeRepository repository = null;
    public Set<ContactType> contactTypeDB = null;

    private ContactTypeRepository(){
        contactTypeDB  = new HashSet<ContactType>();
    }

    public static  ContactTypeRepository getRepository(){
        if (repository == null){
            repository = new ContactTypeRepository();
        }
        return repository;
    }

    public ContactType create(ContactType contactType) {
        boolean success = contactTypeDB.add(contactType);
        if (!success)
            return null;
        return contactType;
    }


    public ContactType read(String contactTypeId) {
        for (ContactType ct :contactTypeDB) {
            if (ct.getContactTypeId().equals(contactTypeId))
                return ct;
        }
        return null;
    }

    public ContactType update(ContactType contactType){
        ContactType oldContactType = read(contactType.getContactTypeId());
        if(oldContactType != null){
            contactTypeDB.remove(oldContactType);
            contactTypeDB.add(contactType);
            return contactType;
        }
        return null;
    }


    public boolean delete(String contactTypeId) {
        ContactType contactTypeTODelete = read (contactTypeId);
        if (contactTypeTODelete == null)
            return false;
        contactTypeDB.remove(contactTypeTODelete);
        return true;
    }


    public Set< ContactType > getAll() {
        return  contactTypeDB;
    }
}