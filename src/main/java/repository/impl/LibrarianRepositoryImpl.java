/*Author:
Date: 
*/
package repository.impl;

import domain.Librarian;
import repository.LibrarianRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LibrarianRepositoryImpl implements LibrarianRepository {

	private static LibrarianRepositoryImpl instance;
	private final Map<String, Librarian> storage = new HashMap<>();

	private LibrarianRepositoryImpl() {
	}

	public static synchronized LibrarianRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new LibrarianRepositoryImpl();
		}
		return instance;
	}

	@Override
	public Librarian create(Librarian entity) {
		storage.put(entity.getStaffId(), entity);
		return entity;
	}

	@Override
	public Optional<Librarian> read(String id) {
		return Optional.ofNullable(storage.get(id));
	}

	@Override
	public Librarian update(Librarian entity) {
		storage.put(entity.getStaffId(), entity);
		return entity;
	}

	@Override
	public boolean delete(String id) {
		return storage.remove(id) != null;
	}

	@Override
	public Collection<Librarian> getAll() {
		return storage.values();
	}
}
