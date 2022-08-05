/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment
 *IRepository: Decor
 */
package za.ac.cput.repository;

import za.ac.cput.entity.Decor;

import java.util.Set;

public interface IDecor extends IRepository<Decor,String>{

        //create,read,update ,delete
        public Set<Decor> getAll();

    }


