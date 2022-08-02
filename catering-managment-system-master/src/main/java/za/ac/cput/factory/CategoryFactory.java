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
import za.ac.cput.helper.RepoHelper;

public class CategoryFactory {

    public static Category createCategory( String Category_Name, String Category_Description) {
        if (RepoHelper.isNullorEmpty(Category_Name) || RepoHelper.isNullorEmpty(Category_Description))
            return null;

        return new Category.Builder().setCategory_ID(RepoHelper.idgenerate())
                .setCategory_Name(Category_Name)
                .setCategory_Description(Category_Description)
                .build();
    }
}

