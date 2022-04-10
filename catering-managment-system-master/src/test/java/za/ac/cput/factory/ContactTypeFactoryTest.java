/* ContactTypeFactoryTest.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ContactType;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTypeFactoryTest {

    @Test
    public void createContactType() {
        ContactType contactType = ContactTypeFactory.createContactType("223", "John Smith", "Customer");
        System.out.println(contactType.toString());
        assertNotNull(contactType);

    }
}
