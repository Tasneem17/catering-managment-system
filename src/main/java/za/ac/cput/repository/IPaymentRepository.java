package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Payment;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment,String> {

    //create,read,update ,delete
    public Set<Payment> getAll();

    Optional<Payment> read(String payment);

}
