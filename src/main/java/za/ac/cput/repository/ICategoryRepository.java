/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.repository;

import za.ac.cput.entity.Category;


import java.util.List;

public interface ICategoryRepository extends IRepository<Category,IRepository> {
    public List<Category> getAll();

}
