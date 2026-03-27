

/* BookFactory.java
   Book factory class
   Author: Nomhle Njengele (2116227488)
   Date: 13 March 2026
*/

package factory;
import domain.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookFactoryTest {

        @Test
        public void testBookIsCreated() {
            Book book = new Book.Builder("B001", "978-0357442234", "Contemporary Project Management")
                    .author("Timothy J. Kloppenborg")
                    .subject("Project Management")
                    .publisher("Cengage")
                    .publicationYear(2019)
                    .build();

            assertNotNull(book);
        }

        @Test
        public void testBookTitle() {
            Book book = new Book.Builder("B001", "978-0357442234", "Contemporary Project Management")
                    .build();

            assertEquals("Contemporary Project Management", book.getTitle());
        }

        @Test
        public void testBookAuthor() {
            Book book = new Book.Builder("B001", "978-0357442234", "Contemporary Project Management")
                    .author("Timothy J. Kloppenborg")
                    .build();

            assertEquals("Timothy J. Kloppenborg", book.getAuthor());
        }
    }

