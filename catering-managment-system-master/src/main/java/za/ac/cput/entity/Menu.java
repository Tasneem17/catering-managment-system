/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.entity;

public class Menu {
    private int Menu_ID;
    private String  Menu_Items;
    private double Menu_Price;

    private Menu(Builder builder) {
        this.Menu_ID = builder.Menu_ID;
        this.Menu_Items = builder.Menu_Items;
       this.Menu_Price = builder.Menu_Price;
    }
    public static class Builder{
        private  int Menu_ID;
        private String  Menu_Items;
        private double Menu_Price;

        public Builder setMenu_ID(int menu_ID) {
            this.Menu_ID = menu_ID;
            return this;
        }

        public Builder setMenu_Items(String menu_Items) {
            this.Menu_Items = menu_Items;
            return this;
        }

        public Builder setMenu_Price(double menu_Price) {
            this.Menu_Price = menu_Price;
            return this;
        }
        public Builder copy(Menu menu){
            this.Menu_ID= menu.Menu_ID;
            this.Menu_Items = menu.Menu_Items;
            this.Menu_Price = menu.Menu_Price;
            return this;
        }
        public Menu build(){
            return new Menu(this);
        }

    }

    public int getMenu_ID() {
        return Menu_ID;
    }

    public void setMenu_ID(int menu_ID) {
        Menu_ID = menu_ID;
    }

    public String getMenu_Items() {
        return Menu_Items;
    }

    public void setMenu_Items(String menu_Items) {
        Menu_Items = menu_Items;
    }

    public double getMenu_Price() {
        return Menu_Price;
    }

    public void setMenu_Price(double menu_Price) {
        Menu_Price = menu_Price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "Menu_ID=" + Menu_ID +
                ", Menu_Items='" + Menu_Items + '\'' +
                ", Menu_Price=" + Menu_Price +
                '}';
    }
}
