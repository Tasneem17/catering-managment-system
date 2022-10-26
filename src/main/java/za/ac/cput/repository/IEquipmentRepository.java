/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment
 *IRepository: Equipment
 */

package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Equipment;

import java.util.Optional;
import java.util.Set;
@Repository
public interface IEquipmentRepository extends JpaRepository<Equipment,String> {

}
