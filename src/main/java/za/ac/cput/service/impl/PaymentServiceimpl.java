package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;

import za.ac.cput.entity.Payment;
import za.ac.cput.repository.IPaymentRepository;
import za.ac.cput.service.PaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceimpl implements PaymentService {
    private final IPaymentRepository repository;
    public PaymentServiceimpl(IPaymentRepository repository){
        this.repository = repository;
    }
    @Override
    public Payment save (Payment payment){
        return this.repository.save(payment);
    }
    @Override
    public Optional<Payment> read(String payment) {
        return this.repository.read(payment);
    }
    @Override
    public boolean delete(Payment payment){
        this.repository.delete(payment);
        return false;
    }

    @Override
    public List<Payment> findAllPayment_id(String payment) {
        return this.repository.findAll();
    }
}
