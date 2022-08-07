package za.ac.cput.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
@Embeddable
public class Menu_Category {
    @ManyToOne
    @JoinColumn(name = "menu_menu_id")
    private     Menu  Menu;
    @ManyToOne
    @JoinColumn(name = "category_ID")
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
