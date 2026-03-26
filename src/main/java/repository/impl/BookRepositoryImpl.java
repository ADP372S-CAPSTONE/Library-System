/* BookRepositoryImpl.java
   Book repository implementation
   Author: Nomhle Njengele (216227488)
   Date: 13 March 2026
*/
package repository.impl;

import domain.Book;
import repository.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

	private static BookRepositoryImpl instance;
	private final Map<String, Book> storage = new HashMap<>();

	private BookRepositoryImpl() {
	}

	public static synchronized BookRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new BookRepositoryImpl();
		}
		return instance;
	}

	private String keyFor(Book book) {
		return book.getBookId();
	}

	@Override
	public Book create(Book entity) {
		storage.put(keyFor(entity), entity);
		return entity;
	}

	@Override
	public Optional<Book> read(String id) {
		return Optional.ofNullable(storage.get(id));
	}

	@Override
	public Book update(Book entity) {
		storage.put(keyFor(entity), entity);
		return entity;
	}

	@Override
	public boolean delete(String id) {
		return storage.remove(id) != null;
	}

	@Override
	public Collection<Book> getAll() {
		return storage.values();
	}
}
