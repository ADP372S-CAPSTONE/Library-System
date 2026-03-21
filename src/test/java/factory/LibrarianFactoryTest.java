package factory;

/* Librarian.java
   Librarian domain class.
   Author: Sinethemba Nyimbinya (220085870).
   Date: 16 March 2026.
*/

import domain.Librarian;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianFactoryTest {

    @Test
    void testCreatesLibrarianWithRequiedFeilds() {


        //Declaration
        String id = "l20067788";
        String name = "Senzo";
        String email = "snyimbinya2517@gmail.com";
        String number = "0721177698";

        // Passing values into factory method
        Librarian librarian = LibrarianFactory.createLibrarian(id , name , email ,number);

        // check is values as set correctly
        assertEquals(id, librarian.getStaffId());
        assertEquals(name, librarian.getName());
        assertEquals(email, librarian.getEmail());
        assertEquals(number, librarian.getNumber());


    }
}








