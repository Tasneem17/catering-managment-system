/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.entity;

public class Category<Static> {
  private  int Category_ID;
private String Category_Name;
private String Category_Description;

    private Category(Builder builder) {
       this.Category_ID = builder.Category_ID;
        this.Category_Name = builder.Category_Name;
        this.Category_Description = builder.Category_Description;
    }


    public int getCategory_ID() {
        return Category_ID;
    }

    public void setCategory_ID(int category_ID) {
        Category_ID = category_ID;
    }

    public String getCategory_Name() {
        return Category_Name;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }

    public String getCategory_Description() {
        return Category_Description;
    }

    public void setCategory_Description(String category_Description) {
        Category_Description = category_Description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "Category_ID=" + Category_ID +
                ", Category_Name='" + Category_Name + '\'' +
                ", Category_Description='" + Category_Description + '\'' +
                '}';
    }
    public static class Builder{
        private  int Category_ID;
        private String Category_Name;
        private String Category_Description;

        public Builder setCategory_ID(int category_ID) {
            this.Category_ID = category_ID;
            return this;
        }

        public Builder setCategory_Name(String category_Name) {
            this.Category_Name = category_Name;
            return this;
        }

        public Builder setCategory_Description(String category_Description) {
            this.Category_Description = category_Description;
            return this;
        }
        public Builder copy(Category category){
            this.Category_ID = category.Category_ID;
            this.Category_Name = category.Category_Name;
            this.Category_Description=category.Category_Description;
            return this;
        }
        public Category build(){
            return new Category(this);
        }
    }


}
