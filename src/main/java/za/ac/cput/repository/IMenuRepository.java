/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.repository;

import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Menu;

import java.util.List;
@Repository
public interface IMenuRepository extends IRepository<Menu,String> {


    public List<Menu> getAll();
}
