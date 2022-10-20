/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *service:IDecorService
 */
package za.ac.cput.service;


import za.ac.cput.entity.Decor;

import java.util.List;
import java.util.Optional;

public interface DecorService {
    Decor save(Decor decor);

    Optional<Decor> read(String decorType);

    boolean delete(Decor decor);

    List<Decor> findAllDecorType(String decorType);

    List<Decor> findAll();

    boolean deleteBydecorType(String decorType);
}
