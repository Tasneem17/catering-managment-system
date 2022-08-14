package za.ac.cput.service.impl;


import za.ac.cput.entity.UserPayment;
import za.ac.cput.repository.UserPaymentRepository;
import za.ac.cput.service.UserPaymentService;

import java.util.List;
import java.util.Optional;

public class UserPaymentServiceimpl implements UserPaymentService {
    private final UserPaymentRepository repository;
    public UserPaymentServiceimpl(UserPaymentRepository repository){
        this.repository = repository;
    }
    @Override
    public UserPayment save (UserPayment userPayment){
        return this.repository.save(userPayment);
    }
    @Override
    public Optional<UserPayment> read(String userPayment) {
        return this.repository.read(userPayment);
    }
    @Override
    public void delete(UserPayment userPayment){
        this.repository.delete(userPayment);
    }

    @Override
    public List<UserPayment> findAllUserPayment_id(String userPayment) {
        return this.repository.findAll();
    }
}

