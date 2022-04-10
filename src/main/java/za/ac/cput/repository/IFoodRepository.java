/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.repository;


import za.ac.cput.entity.Food;


import java.util.List;

public interface IFoodRepository extends IRepository<Food,IRepository> {
    Food read(int Food_ID);

    boolean delete(int Food_ID);

    public List<Food> getAll();
}
