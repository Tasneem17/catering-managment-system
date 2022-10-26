package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Category;
import za.ac.cput.entity.UserPayment;
import za.ac.cput.repository.UserPaymentRepository;
import za.ac.cput.service.UserPaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class UserPaymentServiceimpl implements UserPaymentService {
    private UserPaymentRepository userpaymentRepository;

    @Autowired
    public UserPaymentServiceimpl(UserPaymentRepository userpaymentRepository) {this.userpaymentRepository = userpaymentRepository;}

    public UserPayment save(UserPayment user) {return this.userpaymentRepository.save(user);}

    @Override
    public UserPayment read(String id) {
        return this.userpaymentRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteById(String id){this.userpaymentRepository.deleteById(id);}

    @Override
    public List<UserPayment> findAll() {return this.userpaymentRepository.findAll();}
}


