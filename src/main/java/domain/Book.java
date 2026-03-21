package domain;

//Book domain class
//Author:
//Date:


public class Book {
    private final String isbn;
    private final String title;
    private String author;
    private String subject;
    private String publisher;
    private int publicationYear;

    private Book(Builder builder) {
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.author = builder.author;
        this.subject = builder.subject;
        this.publisher = builder.publisher;
        this.publicationYear = builder.publicationYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title=" + title +
                ", author=" + author +
                ", subject=" + subject +
                ", publisher=" + publisher +
                ", publicationYear=" + publicationYear +
                '}';
    }

    public static class Builder {

        private final String isbn;
        private final String title;
        private String author;
        private String subject;
        private String publisher;
        private int publicationYear;

        public Builder(String isbn, String title) {
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

            //End of program
            
        }
    }
}


