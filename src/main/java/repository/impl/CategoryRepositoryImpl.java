package repository.impl;

import domain.Category;
import repository.CategoryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CategoryRepositoryImpl implements CategoryRepository {

	private final Map<String, Category> storage = new HashMap<>();

	@Override
	public Category create(Category entity) {
		storage.put(entity.getCategoryId(), entity);
		return entity;
	}

	@Override
	public Optional<Category> read(String id) {
		return Optional.ofNullable(storage.get(id));
	}

	@Override
	public Category update(Category entity) {
		storage.put(entity.getCategoryId(), entity);
		return entity;
	}

	@Override
	public boolean delete(String id) {
		return storage.remove(id) != null;
	}

	@Override
	public List<Category> findAll() {
		return new ArrayList<>(storage.values());
	}

	@Override
	public Optional<Category> findByName(String name) {
		return storage.values().stream()
				.filter(category -> category.getName().equalsIgnoreCase(name))
				.findFirst();
	}

	@Override
	public List<Category> findByNameContaining(String keyword) {
		List<Category> results = new ArrayList<>();
		for (Category category : storage.values()) {
			if (category.getName().toLowerCase().contains(keyword.toLowerCase())) {
				results.add(category);
			}
		}
		return results;
	}

	@Override
	public boolean existsByName(String name) {
		return storage.values().stream()
				.anyMatch(category -> category.getName().equalsIgnoreCase(name));
	}
}
