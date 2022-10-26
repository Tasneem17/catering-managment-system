/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment
 *IRepository: EquipmentChoice
 */
package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.EquipmentChoice;


import java.util.Set;
@Repository
public interface IEquipmentChoiceRepository extends JpaRepository<EquipmentChoice,String> {


}

