/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Entity:Decor
 */
package za.ac.cput.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Decor {
  @NotNull@Id private String decorType;
    private String decorSize;
    private String decorQuantity;
    private String cost;

private Decor(){}
    private Decor(Decor.Builder builder) {
        this.decorType = builder.decorType;
        this.decorSize = builder.decorSize;
        this.decorQuantity= builder.decorQuantity;
        this.cost= builder.cost;
    }

    public String getDecorType() {
        return decorType;
    }

    public String getDecorSize() {
        return decorSize;
    }

    public String getDecorQuantity() {
        return decorQuantity;
    }

    public String getCost() {
        return cost;
    }

    public void setDecorType(String decorType) {

        this.decorType= decorType;
    }

    public void setDecorSize(String decorSize) {

        this.decorSize= decorSize;
    }

    public void setDecorQuantity(String decorQuantity) {

        this.decorQuantity= decorQuantity;
    }

    public void setCost(String cost) {

        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Decor{" +
                "decorType='" + decorType + '\'' +
                ", decorSize='" + decorSize + '\'' +
                ", decorQuantity='" + decorQuantity + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }


    public void set(String decorType, String decorSize, String decorQuantity, String cost) {
        this.decorType = decorType;
        this.decorSize = decorSize;
        this.decorQuantity = decorQuantity;
        this.cost = cost;

    }
    public static class Builder{
        private String decorType;
        private String decorSize;
        private String decorQuantity;
        private String cost;

        public Decor.Builder setDecorType(String decorType) {
            this.decorType= decorType;
            return this;
        }

        public Decor.Builder setDecorSize(String decorSize) {
            this.decorSize = decorSize;
            return this;
        }

        public Decor.Builder setDecorQuantity(String decorQuantity) {
            this.decorQuantity = decorQuantity;
            return this;
        }

        public Decor.Builder setCost(String cost) {
            this.cost = cost;
            return this;
        }
        public Decor.Builder copy(Decor decor) {
            this.decorType = decor.decorType;
            this.decorSize = decor.decorSize;
            this.decorQuantity = decor.decorQuantity;
            this.cost = decor.cost;
            return this;
        }
        public Decor build() {
            return new Decor(this);

        }
    }
}

