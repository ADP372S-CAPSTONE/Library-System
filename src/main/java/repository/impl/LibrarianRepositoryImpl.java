package repository.impl;

import domain.Librarian;
import repository.LibrarianRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LibrarianRepositoryImpl implements LibrarianRepository {

	private final Map<String, Librarian> storage = new HashMap<>();

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
	public List<Librarian> findAll() {
		return new ArrayList<>(storage.values());
	}
}
