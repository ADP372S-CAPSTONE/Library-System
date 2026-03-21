package repository.impl;

import domain.Publisher;
import repository.PublisherRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PublisherRepositoryImpl implements PublisherRepository {

	private final Map<String, Publisher> storage = new HashMap<>();

	@Override
	public Publisher create(Publisher entity) {
		storage.put(entity.getPublisherID(), entity);
		return entity;
	}

	@Override
	public Optional<Publisher> read(String id) {
		return Optional.ofNullable(storage.get(id));
	}

	@Override
	public Publisher update(Publisher entity) {
		storage.put(entity.getPublisherID(), entity);
		return entity;
	}

	@Override
	public boolean delete(String id) {
		return storage.remove(id) != null;
	}

	@Override
	public List<Publisher> findAll() {
		return new ArrayList<>(storage.values());
	}
}
