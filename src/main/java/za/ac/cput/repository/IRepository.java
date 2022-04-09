/*  IRepository.java
    Generic repository of the system
    Author: Wilbur Deano Smith (220003033)
    Date: 7 April 2022
*/
package za.ac.cput.repository;

public interface IRepository<T,W> {
    T create(T t);
    T read(W w);
    T update(T t);
    boolean delete(W w);
}
