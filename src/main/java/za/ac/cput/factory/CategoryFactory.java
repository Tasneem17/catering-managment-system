/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.factory;

import za.ac.cput.entity.Category;
import za.ac.cput.entity.Menu;
import za.ac.cput.util.Helper;


public class CategoryFactory {

    public static Category createCategory( String Category_Name, String Category_Description) {
        if (Helper.isNullorEmpty(Category_Name) || Helper.isNullorEmpty(Category_Description))
            return null;

        return new Category.Builder().setCategory_ID(Helper.generateID())
                .setCategory_Name(Category_Name)
                .setCategory_Description(Category_Description)
                .build();
    }
}

