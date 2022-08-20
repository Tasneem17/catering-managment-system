/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *service:IDecorService
 */
package za.ac.cput.service;


import za.ac.cput.entity.Decor;

import java.util.List;

public interface DecorService extends IService<Decor,String>{
    List<Decor> findAllDecorType(String decorType);

    List<Decor> findAll();

    void deleteBydecorType(String decorType);
}
