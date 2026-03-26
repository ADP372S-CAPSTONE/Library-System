/*Librarian Repository implementation Test
 Author: Sinethemba Nyimbinya (220085870).
 Date: 23 March 2026.
*/
package repository.impl;

import domain.Librarian;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianRepositoryImplTest {

    @Test
    void testCreateReadUpdateDelete() {
        LibrarianRepositoryImpl repository = LibrarianRepositoryImpl.getInstance();

        Librarian librarian = new Librarian.Builder().setLibrarianId("L001").setName("Senzo").setEmail("senzo@email.com").setNumber("0721111111").build();
        repository.create(librarian);

        assertTrue(repository.read("L001").isPresent());

        Librarian updatedLibrarian = new Librarian.Builder().setLibrarianId("L001").setName("Senzo Updated").setEmail("senzo@email.com").setNumber("0721111111").build();
        repository.update(updatedLibrarian);
        assertTrue(repository.read("L001").isPresent());

        assertTrue(repository.delete("L001"));
        assertFalse(repository.read("L001").isPresent());
    }
}

