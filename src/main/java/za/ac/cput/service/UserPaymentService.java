package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.UserPayment;

import java.util.List;

@Service
public interface UserPaymentService  extends IService<UserPayment,String>{

    List<UserPayment> findAllUserPayment_id(String userPayment);

    void deleteByuserPayment(String userPayment);

    List<UserPayment> findAll();
}
