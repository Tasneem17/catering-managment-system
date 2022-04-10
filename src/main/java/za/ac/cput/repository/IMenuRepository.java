/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.repository;

import za.ac.cput.entity.Menu;

import java.util.List;

public interface IMenuRepository extends IRepository<Menu,IRepository> {


    public List<Menu> getAll();
}
