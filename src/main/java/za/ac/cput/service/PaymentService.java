package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Payment;

import java.util.List;
import java.util.Optional;


@Service
public interface PaymentService{

    Optional<Payment> read(String s);

    void deleteById(String id);

    List<Payment> findAll();
}
