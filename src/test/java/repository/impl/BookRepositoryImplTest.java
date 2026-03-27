/* BookRepositoryImplTest.java
   Book repository implementation test
   Author: Nomhle Ngengele 216227488
   Date: 23 March 2026
*/
package repository.impl;

import domain.Book;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryImplTest {

    @Test
    void testCreate() {
        BookRepositoryImpl repository = BookRepositoryImpl.getInstance();
        Book book = new Book.Builder("B001", "9780134685991", "Effective Java")
                .author("Joshua Bloch")
                .build();

        Book createdBook = repository.create(book);

        assertNotNull(createdBook);
        assertEquals("Effective Java", createdBook.getTitle());
        assertEquals("Joshua Bloch", createdBook.getAuthor());
    }

    @Test
    void testRead() {
        BookRepositoryImpl repository = BookRepositoryImpl.getInstance();
        Book book = new Book.Builder("B002", "9780596007126", "Head First Java")
                .author("Bert Bates")
                .build();

        repository.create(book);
        String key = book.getBookId();

        Optional<Book> foundBook = repository.read(key);

        assertTrue(foundBook.isPresent());
        assertEquals("Head First Java", foundBook.get().getTitle());
    }

    @Test
    void testUpdate() {
        BookRepositoryImpl repository = BookRepositoryImpl.getInstance();
        Book book = new Book.Builder("B003", "9781491927281", "Learning Java")
                .author("Patrick Niemeyer")
                .build();

        repository.create(book);
        String key = book.getBookId();

        Book updatedBook = new Book.Builder("B003", "9781491927281", "Learning Java - Updated Edition")
                .author("Patrick Niemeyer")
                .build();

        repository.update(updatedBook);

        Optional<Book> result = repository.read(key);
        assertTrue(result.isPresent());
        assertEquals("Learning Java - Updated Edition", result.get().getTitle());
    }

    @Test
    void testDelete() {
        BookRepositoryImpl repository = BookRepositoryImpl.getInstance();
        Book book = new Book.Builder("B004", "9781449355739", "Java 8 in Action")
                .author("Raoul-Gabriel Urma")
                .build();

        repository.create(book);
        String key = book.getBookId();

        boolean deleted = repository.delete(key);

        assertTrue(deleted);
        assertFalse(repository.read(key).isPresent());
    }

    @Test
    void testGetAll() {
        BookRepositoryImpl repository = BookRepositoryImpl.getInstance();
        Book book1 = new Book.Builder("B005", "9780134685991", "Effective Java").build();
        Book book2 = new Book.Builder("B006", "9780596007126", "Head First Java").build();

        repository.create(book1);
        repository.create(book2);

        Collection<Book> allBooks = repository.getAll();

        assertNotNull(allBooks);
        assertTrue(allBooks.size() >= 2);
    }
}

