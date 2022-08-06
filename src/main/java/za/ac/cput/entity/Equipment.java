/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Entity:Equipment
 */
package za.ac.cput.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Equipment {
    @NotNull@Id private String equipmentID;
    private String equipmentDescription;
    private String equipmentQuantity;
    private String equipmentPrice;

private Equipment(){}
    private Equipment(Equipment.Builder builder) {
        this.equipmentID = builder.equipmentID;
        this.equipmentDescription = builder.equipmentDescription;
        this.equipmentQuantity = builder.equipmentQuantity ;
        this.equipmentPrice = builder.equipmentPrice;
    }

    public String getEquipmentID() {
        return equipmentID;
    }

    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    public String getEquipmentQuantity() {
        return equipmentQuantity;
    }

    public String getEquipmentPrice() {
        return equipmentPrice;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
    }

    public void setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
    }

    public void setEquipmentQuantity(String equipmentQuantity) {
        this.equipmentQuantity= equipmentQuantity;
    }

    public void setEquipmentPrice(String equipmentPrice) {
        this.equipmentPrice = equipmentPrice;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentID='" + equipmentID + '\'' +
                ", equipmentDescription='" + equipmentDescription + '\'' +
                ", equipmentQuantity='" + equipmentQuantity + '\'' +
                ", equipmentPrice='" + equipmentPrice + '\'' +
                '}';
    }


    public void set(String equipmentID, String equipmentDescription, String equipmentQuantity, String equipmentPrice) {
        this.equipmentID = equipmentID;
        this.equipmentDescription = equipmentDescription;
        this.equipmentQuantity= equipmentQuantity;
        this.equipmentPrice = equipmentPrice;

    }
    public static class Builder{
        private String equipmentID;
        private String equipmentDescription;
        private String equipmentQuantity;
        private String equipmentPrice;

        public Equipment.Builder setEquipmentID(String equipmentID){
            this.equipmentID = equipmentID;
            return this;
        }

        public Equipment.Builder setEquipmentDescription(String equipmentDescription) {
            this.equipmentDescription = equipmentDescription;
            return this;
        }

        public Equipment.Builder setEquipmentQuantity(String equipmentQuantity) {
            this.equipmentQuantity = equipmentQuantity;
            return this;
        }

        public Equipment.Builder setEquipmentPrice(String equipmentPrice) {
            this.equipmentPrice =equipmentPrice;
            return this;
        }
        public Equipment.Builder copy(Equipment equipment) {
            this.equipmentID = equipment.equipmentID;
            this.equipmentDescription = equipment.equipmentDescription;
            this.equipmentQuantity = equipment.equipmentQuantity;
            this.equipmentPrice = equipment.equipmentPrice;
            return this;
        }
        public Equipment build() {
            return new Equipment(this);

        }
    }
}



