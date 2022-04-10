package za.ac.cput.helper;

/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
import za.ac.cput.entity.Menu;

import java.util.ArrayList;

public class MenuStorage {
    private static MenuStorage repo = null;
    private ArrayList<Menu> menuDB=null;

    public MenuStorage(){
        menuDB = new ArrayList<Menu>();

    }
public static MenuStorage getRepo(){
        if(repo==null){
            repo = new MenuStorage();
    }
        return repo;
}


}
