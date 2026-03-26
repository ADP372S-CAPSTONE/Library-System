/* BookRepositoryImpl.java
   Book repository implementation
   Author: Tiyani Ngwana (231266731)
   Date: 13 March 2026
*/
package repository.impl;

import domain.Book;
import repository.BookRepository;

import java.util.Collection;
import java.util.HashMap;

public class BookRepositoryImpl implements BookRepository {
    private final HashMap<String, Book> bookStore = new HashMap<>();
    private static BookRepositoryImpl instance = null;

    private BookRepositoryImpl() {}

    public static BookRepositoryImpl getInstance() {
        if (instance == null) instance = new BookRepositoryImpl();
        return instance;
    }

    @Override
    public Book create(Book book) {
        if (book == null || bookStore.containsKey(book.getBookId())) return null;
        bookStore.put(book.getBookId(), book);
        return book;
    }

    @Override
    public Book read(String id) {
        return bookStore.getOrDefault(id, null);
    }

    @Override
    public Book update(Book book) {
        if (book == null || !bookStore.containsKey(book.getBookId())) return null;
        bookStore.put(book.getBookId(), book);
        return book;
    }

    @Override
    public boolean delete(String id) {
        if (!bookStore.containsKey(id)) return false;
        bookStore.remove(id);
        return true;
    }

    @Override
    public Collection<Book> getAll() {
        return bookStore.values();
    }
}

