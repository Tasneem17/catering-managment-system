package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Payment;

import java.util.List;


@Service
public interface PaymentService extends IService<Payment,String>{

    List<Payment> findAllPayment_id(String payment);

    void deleteBypayment(String payment);

    List<Payment> findAll();
}
