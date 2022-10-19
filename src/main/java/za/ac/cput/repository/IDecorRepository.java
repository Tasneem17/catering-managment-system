/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment
 *IRepository: Decor
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Decor;

import java.util.Optional;
import java.util.Set;
@Repository
public interface IDecorRepository extends JpaRepository<Decor,String> {

        //create,read,update ,delete
        public Set<Decor> getAll();

    Optional<Decor> read(String decorType);

    Decor create(Decor decor);
}


