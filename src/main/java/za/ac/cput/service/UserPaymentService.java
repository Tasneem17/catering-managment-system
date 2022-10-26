package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.UserPayment;

import java.util.List;

@Service
public interface UserPaymentService  {


    UserPayment read(String s);

    void deleteById(String id);

    UserPayment save(UserPayment UserPayment);
    List<UserPayment> findAll();
}
