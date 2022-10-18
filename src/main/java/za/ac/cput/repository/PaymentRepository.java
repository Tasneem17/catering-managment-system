package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,String> {

}
