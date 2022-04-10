/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;

public interface IRepository <T, ID>
{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);


}