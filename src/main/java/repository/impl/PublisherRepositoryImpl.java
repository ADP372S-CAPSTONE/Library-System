/*Author:
Date:
*/
package repository.impl;

import domain.Publisher;
import repository.PublisherRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PublisherRepositoryImpl implements PublisherRepository {

	private static PublisherRepositoryImpl instance;
	private final Map<String, Publisher> storage = new HashMap<>();

	private PublisherRepositoryImpl() {
	}

	public static synchronized PublisherRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new PublisherRepositoryImpl();
		}
		return instance;
	}

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
	public Collection<Publisher> getAll() {
		return storage.values();
	}
}
