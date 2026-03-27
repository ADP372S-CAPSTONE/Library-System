
/* Book.java
   Book domain class
   Author: Nomhle Njengele (216227488)
   Date: 13 March 2026
*/

package domain;


public class  Book {

    private final String bookId;
    private final String isbn;
    private final String title;
    private final String author;
    private final String subject;
    private final String publisher;
    private final int publicationYear;

    private Book(Builder builder) {
        this.bookId = builder.bookId;
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.author = builder.author;
        this.subject = builder.subject;
        this.publisher = builder.publisher;
        this.publicationYear = builder.publicationYear;
    }

    public String getBookId() { return bookId; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getSubject() { return subject; }
    public String getPublisher() { return publisher; }
    public int getPublicationYear() { return publicationYear; }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn=" + isbn +
                ", title=" + title +
                ", author=" + author +
                ", subject=" + subject +
                ", publisher=" + publisher +
                ", publicationYear=" + publicationYear +
                '}';
    }

    public static class Builder {

        private final String bookId;
        private final String isbn;
        private final String title;
        private String author;
        private String subject;
        private String publisher;
        private int publicationYear;

        public Builder(String bookId, String isbn, String title) {
            this.bookId = bookId;
            this.isbn = isbn;
            this.title = title;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder publicationYear(int publicationYear) {
            this.publicationYear = publicationYear;
            return this;
        }

        public Book build() {
            return new Book(this);

            //End of program.
            
        }
    }
}


