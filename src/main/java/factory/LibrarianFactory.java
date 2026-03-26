/* LibrarianFactory.java
   Librarian factory class
   Author: Sinethemba Nyimbinya (220085870)
   Date: 16 March 2026
*/
package factory;

import domain.Librarian;

public class LibrarianFactory{
    public static Librarian createLibrarian(String id,
                                            String name,
                                            String email,
                                            String number){
        return new Librarian.Builder()
                .setLibrarianId(id)
                .setName(name)
                .setEmail(email)
                .setNumber(number)
                .build();

    }

}
