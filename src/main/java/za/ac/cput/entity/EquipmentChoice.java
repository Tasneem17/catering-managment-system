/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Entity:EquipmentChoice
 */
package za.ac.cput.entity;

public class EquipmentChoice {
    private String choiceCustomer;
    private String choiceCompany;



    private EquipmentChoice(EquipmentChoice.Builder builder) {
        this.choiceCustomer = builder.choiceCustomer;
        this.choiceCompany = builder.choiceCompany;

    }

    public String getChoiceCustomer() {
        return choiceCustomer;
    }

    public String getChoiceCompany() {
        return choiceCompany;
    }

    public void setChoiceCustomer(String choiceCustomer) {
        this.choiceCustomer = choiceCustomer;
    }

    public void setChoiceCompany(String choiceCompany) {
        this.choiceCompany = choiceCompany;
    }

    @Override
    public String toString() {
        return "EquipmentChoice{" +
                "choiceCustomer='" + choiceCustomer + '\'' +
                ", choiceCompany='" + choiceCompany + '\'' +
                '}';
    }


    public void set(String choiceCustomer, String choiceCompany) {
        this.choiceCustomer = choiceCustomer;
        this.choiceCompany = choiceCompany;


    }
    public static class Builder{
        private String choiceCustomer;
        private String choiceCompany;


        public EquipmentChoice.Builder setChoiceCustomer(String choiceCustomer) {
            this.choiceCustomer= choiceCustomer;
            return this;
        }

        public EquipmentChoice.Builder setChoiceCompany(String choiceCompany) {
            this.choiceCompany = choiceCompany;
            return this;
        }



        public EquipmentChoice.Builder copy(EquipmentChoice equipmentChoice) {
            this.choiceCustomer = equipmentChoice.choiceCustomer;
            this.choiceCompany = equipmentChoice.choiceCompany;

            return this;
        }
        public EquipmentChoice build() {
            return new EquipmentChoice(this);

        }
    }
}

