package za.ac.cput.service;

import org.springframework.stereotype.Repository;
import za.ac.cput.entity.UserContact;
import za.ac.cput.service.IService;

import java.util.List;

//@Repository
public interface UserContactService extends IService <UserContact, String>{

    boolean deletebyid(String id);
    List<UserContact> findAll();

}
