package za.ac.cput.service;

import za.ac.cput.entity.UserContact;
import za.ac.cput.service.IService;

import java.util.List;

public interface UserContactService extends IService <UserContact, String>{

    List<UserContact> findAll();

}
