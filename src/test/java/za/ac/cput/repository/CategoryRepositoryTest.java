/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Category;
import za.ac.cput.factory.CategoryFactory;


import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class CategoryRepositoryTest {


    private static CategoryRepository repo = CategoryRepository.getRepo();
    private static Category cat = CategoryFactory.createCategory("Bread",
            "BreadRooll and Tortilla");



    @Test
    void a_create() {
        Category  created  = repo.create(cat);
        assertEquals(cat.getCategory_ID(),created.getCategory_ID());
        System.out.println("Record created:"+created);
    }

    @Test
    void c_read() {
        Category read = repo.read(cat.getCategory_ID());
        assertNotNull(read);
        System.out.println("Reading Record:"+read);
    }

    @Test
    void b_update() {
        Category update =new Category.Builder().copy(cat).setCategory_Name("Protein")
                .setCategory_Description("Beef and Chicken").build();
        assertNotNull(repo.update(update));
        System.out.println("Record updated:"+update);

    }

    @Test
    void e_delete() {
        boolean delete =repo.delete(cat.getCategory_ID());
        assertTrue(delete);
        System.out.println("Record deleted:"+delete);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all");
        System.out.println(repo.getAll());
    }
}