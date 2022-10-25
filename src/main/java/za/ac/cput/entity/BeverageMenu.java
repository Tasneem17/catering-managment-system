/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Entity :BeverageMenu
 */
package za.ac.cput.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class  BeverageMenu {


    public int length;
    @NotNull@Id
    private String beverageName;
    private String price;
    private String description;
    private String quantity;
    private String availability;
private BeverageMenu(){}

    private BeverageMenu(Builder builder) {
        this.beverageName = builder.beverageName;
        this.price = builder.price;
        this.description = builder.description;
        this.quantity = builder.quantity ;
        this.availability = builder.availability;
    }

    public String getBeverageName() {
        return beverageName;}

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getAvailability() {
        return availability;
    }



    public void setBeverageName(String beverageName) {
        this.beverageName= beverageName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description){
        this.description = description;}

    public void setQuantity(String quantity){
        this.quantity = quantity;}

    public void setAvailability(String availability) {
        this.availability = availability;}

    @Override
    public String toString() {
        return "BeverageMenu{" +
                "beverageName='" + beverageName + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", quantity='" + quantity + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }

    public void set(String beverageName, String price, String description, String quantity, String availability) {
        this.beverageName = beverageName;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.availability = availability;

    }
    public static class Builder{

        private String beverageName;
        private String price;
        private String description;
        private String quantity;
        private String availability;

        public Builder setBeverageName(String beverageName) {
            this.beverageName = beverageName;
            return this;
        }

        public  Builder setPrice(String price) {
            this.price = price;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setQuantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setAvailability(String availability) {
            this.availability = availability;
            return this;
        }
        public Builder copy(BeverageMenu beverageMenu) {
            this.beverageName = beverageMenu.beverageName;
            this.price = beverageMenu.price;
            this.description = beverageMenu.description;
            this.quantity = beverageMenu.quantity;
            this.availability = beverageMenu.availability;
            return this;
        }
        public BeverageMenu build() {
            return new BeverageMenu(this);

        }
    }
}
