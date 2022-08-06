package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.UserPayment;

import java.util.Set;

public interface UserPaymentInfo extends JpaRepository<UserPayment,String> {

    //create,read,update ,delete
    public Set<UserPayment> getAll();
}
