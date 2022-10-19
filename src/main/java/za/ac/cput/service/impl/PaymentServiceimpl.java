package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.entity.Payment;
import za.ac.cput.repository.PaymentRepository;
import za.ac.cput.service.PaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceimpl implements PaymentService {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceimpl(PaymentRepository paymentRepository) {this.paymentRepository = paymentRepository;}

    public Payment save(Payment user) {return this.paymentRepository.save(user);}

    public Optional<Payment> read(String s) {return this.paymentRepository.findById(s);}

    public boolean delete(Payment payment) {this.paymentRepository.delete(payment);
        return false;
    }

    public void deleteById(String id){this.paymentRepository.deleteById(id);}


    public List<Payment> findAll() {return this.paymentRepository.findAll();}
}


