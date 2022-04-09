/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment
 *IRepository: Equipment
 */

package za.ac.cput.repository;
import za.ac.cput.entity.Equipment;
import java.util.Set;

public interface IEquipment extends IRepository<Equipment,String>{
    //create,read,update ,delete
    public Set<Equipment> getAll();
}
