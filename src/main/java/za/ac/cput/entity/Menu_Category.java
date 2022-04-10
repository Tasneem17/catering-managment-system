package za.ac.cput.entity;
/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
public class Menu_Category {
    private     Menu  Menu;
    private  Category Category;

    public za.ac.cput.entity.Menu getMenu() {
        return Menu;
    }

    public void setMenu(za.ac.cput.entity.Menu menu) {
        Menu = menu;
    }

    public za.ac.cput.entity.Category getCategory() {
        return Category;
    }

    public void setCategory(za.ac.cput.entity.Category category) {
        Category = category;
    }
}
