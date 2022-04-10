/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Repository: BeverageMenu Repository
 */

package za.ac.cput.repository;
import za.ac.cput.entity.BeverageMenu;
import java.util.HashSet;
import java.util.Set;

public class BeverageMenuRepository implements IBeverageMenu{
    private static BeverageMenuRepository repository = null;
    private Set<BeverageMenu> beverageMenuDB = null;

    private BeverageMenuRepository(){
        beverageMenuDB  = new HashSet<BeverageMenu>();
    }

    public static  BeverageMenuRepository getRepository(){
        if (repository == null){
            repository = new BeverageMenuRepository();
        }
        return repository;
    }

    @Override
    public BeverageMenu create(BeverageMenu beverageMenu) {
        boolean success = beverageMenuDB.add(beverageMenu);
        if (!success)
            return null;
        return beverageMenu;
    }

    @Override
    public BeverageMenu read(String BeverageName) {
        for (BeverageMenu b :beverageMenuDB) {
            if (b.getBeverageName().equals(BeverageName))
                return b;
        }

           return null;

    }

    @Override
    public BeverageMenu update(BeverageMenu beverageMenu) {
        BeverageMenu oldBeverageMenu = read(beverageMenu.getBeverageName());
        if (oldBeverageMenu != null) {
            beverageMenuDB.remove(oldBeverageMenu);
            beverageMenuDB.add(beverageMenu);
            return beverageMenu;
        }
        return null;

    }


    @Override
    public boolean delete(String beverageName) {
        BeverageMenu   beverageMenuTODelete = read (beverageName);
        if (beverageMenuTODelete == null)
            return false;
        beverageMenuDB.remove(beverageMenuTODelete);
        return true;
    }


    @Override
    public Set< BeverageMenu > getAll() {
        return  beverageMenuDB;
    }
}


