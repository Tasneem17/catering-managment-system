/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;

import za.ac.cput.entity.UserContact;

import java.util.HashSet;
import java.util.Set;

public class UserContactRepository implements IUserContactRepository{
    private static UserContactRepository repository = null;
    private Set<UserContact> userContactDB = null;

    private UserContactRepository(){
        userContactDB = new HashSet<UserContact>();
    }

    public static UserContactRepository getRepository(){
        if (repository ==null){
            repository = new UserContactRepository();

        }
        return repository;
    }


    @Override
    public UserContact create(UserContact userContact){
        this.userContactDB.add(userContact);
        return userContact;
    }



    @Override
    public UserContact read(String userContactId){
        for (UserContact c: userContactDB) {
            if (c.getUserId().equals(userContactId)){
                return c;
            }

        }
        return null;
    }
    @Override
    public UserContact update(UserContact event) {
        UserContact firstEvent = read(event.getUserId());
        if( firstEvent !=null) {
            userContactDB.remove(firstEvent);
            userContactDB.add(event);
            return event;
        }
        return null;
    }



    @Override
    public boolean delete(String userID) {
        UserContact deleteEvent = read(userID);
        if (deleteEvent ==null) {
            System.out.println("User is null.");
        }
        userContactDB.remove(deleteEvent);
        System.out.println("Event Removed.");
        return false;
    }
    @Override
    public Set<UserContact> getAll(){return userContactDB;}
}
