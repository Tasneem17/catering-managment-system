/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.repository;


import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Food;


import java.util.List;
@Repository
public interface IFoodRepository extends IRepository<Food,String> {

    public List<Food> getAll();
}
