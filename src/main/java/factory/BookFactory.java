/* BookFactory.java
   Book factory class
   Author: Nomhle Njengele (216227488)
   Date: 13 March 2026
*/
package factory;

import domain.Book;

public class BookFactory {

    public static Book createBasicBook(String bookId, String isbn, String title) {
        return new Book.Builder(bookId, isbn, title)
                .build();
    }

    public static Book createBook(String bookId, String isbn, String title, String author, String subject, String publisher, int publicationYear) {
        return new Book.Builder(bookId, isbn, title)
                .author(author)
                .subject(subject)
                .publisher(publisher)
                .publicationYear(publicationYear)
                .build();
    }

    public static void main(String[] args) {
        Book book = createBook(
                "B001",
                "978-0357442234",
                "Contemporary Project Management",
                "Timothy J. Kloppenborg",
                "Project Management",
                "Cengage",
                2019
        );

        System.out.println(book);
    }
}

