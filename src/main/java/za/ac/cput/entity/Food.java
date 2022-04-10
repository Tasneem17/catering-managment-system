/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.entity;

public class Food {

    private   int  Food_ID;
    private String Food_Name;
    private String Food_Description;
    private String Food_Quantity;
    private double Food_Price;

    private Food(Builder builder) {
        this.Food_ID = builder.Food_ID;
        this.Food_Name = builder.Food_Name;
        this.Food_Description = builder.Food_Description;
      this.Food_Quantity = builder.Food_Quantity;
      this.Food_Price = builder.Food_Price;
    }
    public static class Builder{
        private   int  Food_ID;
        private String Food_Name;
        private String Food_Description;
        private String Food_Quantity;
        private double Food_Price;

        public Builder setFood_ID(int food_ID) {
            Food_ID = food_ID;
            return this;
        }

        public Builder setFood_Name(String food_Name) {
            Food_Name = food_Name;
            return this;
        }

        public Builder setFood_Description(String food_Description) {
            Food_Description = food_Description;
            return this;
        }

        public Builder setFood_Quantity(String food_Quantity) {
            Food_Quantity = food_Quantity;
            return this;
        }

        public Builder setFood_Price(double food_Price) {
            Food_Price = food_Price;
            return this;
        }
        public Builder copy(Food food){
            this.Food_ID = food.Food_ID;
            this.Food_Name = food.Food_Name;
            this.Food_Description = food.Food_Description;
            this.Food_Quantity = food.Food_Quantity;
            this.Food_Price= food.Food_Price;
            return this;
        }
        public Food build(){
            return  new Food(this);
        }
    }

    public int getFood_ID() {
        return Food_ID;
    }

    public void setFood_ID(int food_ID) {
        Food_ID = food_ID;
    }

    public String getFood_Name() {
        return Food_Name;
    }

    public void setFood_Name(String food_Name) {
        Food_Name = food_Name;
    }

    public String getFood_Description() {
        return Food_Description;
    }

    public void setFood_Description(String food_Description) {
        Food_Description = food_Description;
    }

    public String getFood_Quantity() {
        return Food_Quantity;
    }

    public void setFood_Quantity(String food_Quantity) {
        Food_Quantity = food_Quantity;
    }

    public double getFood_Price() {
        return Food_Price;
    }

    public void setFood_Price(double food_Price) {
        Food_Price = food_Price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "Food_ID=" + Food_ID +
                ", Food_Name='" + Food_Name + '\'' +
                ", Food_Description='" + Food_Description + '\'' +
                ", Food_Quantity='" + Food_Quantity + '\'' +
                ", Food_Price=" + Food_Price +
                '}';
    }
}
