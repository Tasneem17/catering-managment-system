package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.UserPayment;

import java.util.Optional;
import java.util.Set;
@Repository
public interface UserPaymentRepository extends JpaRepository<UserPayment,String> {

}
