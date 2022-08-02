/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.repository;

import za.ac.cput.entity.Menu;

import java.util.ArrayList;
import java.util.List;

public  class MenuRepository implements IMenuRepository {

    private static MenuRepository repo = null;
    private List<Menu> menuDB=null;

    public MenuRepository(){
        menuDB = new ArrayList<Menu>();

    }
    public static MenuRepository getRepo(){
        if(repo==null){
            repo = new MenuRepository();
        }
        return repo;
    }
@Override
    public Menu create(Menu menu){
       boolean success =menuDB.add(menu);
       if(!success)
           return null;
       return menu;
    }
@Override
    public  Menu read(int Menu_ID){
        for (Menu m : menuDB){
            if(m.getMenu_ID()==Menu_ID)
                return m;
        }
        return null;
}
@Override
 public Menu update(Menu menu){
Menu oldMnenu = read(menu.getMenu_ID());
if(oldMnenu !=null){
    menuDB.remove(oldMnenu);
    menuDB.add(menu);
    return menu;
}
return null;
 }

    @Override
    public boolean delete(int Menu_ID) {
        Menu menuToDelete = read(Menu_ID);
        if(menuToDelete == null) {
            System.out.println("Nothing to delete: ");
            return false;
        }
            menuDB.remove(menuToDelete);
        System.out.println("Delete success: ");
            return true;
    }
public List<Menu> getAll(){
        return menuDB;
}
}
