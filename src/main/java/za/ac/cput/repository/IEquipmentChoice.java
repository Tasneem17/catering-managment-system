/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment
 *IRepository: EquipmentChoice
 */
package za.ac.cput.repository;
import za.ac.cput.entity.EquipmentChoice;

import java.util.Set;

public interface IEquipmentChoice extends IRepository<EquipmentChoice,String>{

        //create,read,update ,delete
        public Set<EquipmentChoice> getAll();
    }

