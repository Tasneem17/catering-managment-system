/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Repository:Decor Repository
 */
package za.ac.cput.repository;
import za.ac.cput.entity.Decor;
import java.util.HashSet;
import java.util.Set;

public class DecorRepository  implements IDecor{
    private static DecorRepository repository = null;
    private Set<Decor> decorDB = null;

    private DecorRepository(){
        decorDB = new HashSet<Decor>();
    }

    public static  DecorRepository getRepository(){
        if (repository == null){
            repository = new DecorRepository();
        }
        return repository;
    }

    @Override
    public Decor create(Decor decor) {
        boolean success = decorDB.add(decor);
        if (!success)
            return null;
        return decor;
    }

    @Override
    public Decor read(String decorType) {
        for (Decor d :decorDB) {
            if (d.getDecorType().equals(decorType))
                return d;
        }
        return null;

    }

    @Override
    public Decor  update(Decor  decor ){
        Decor  oldDecor  = read(decor.getDecorType());
        if(oldDecor != null){
            decorDB.remove(oldDecor);
            decorDB.add(decor);
            return decor;
        }
        return null;
    }

    @Override
    public boolean delete(String decorType) {
       Decor decorTODelete = read (decorType);
        if (decorTODelete == null)
            return false;
        decorDB.remove(decorTODelete);
        return true;
    }


    @Override
    public Set< Decor> getAll() {
        return   decorDB;
    }
}

