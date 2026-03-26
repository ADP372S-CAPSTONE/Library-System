/* 
Author: Ngwana Tiyani 231266731
Date: 16 March 2026
*/

package repository.impl;

import domain.Category;
import repository.CategoryRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CategoryRepositoryImpl implements CategoryRepository {

	private static CategoryRepositoryImpl instance;
	private final Map<String, Category> storage = new HashMap<>();

	private CategoryRepositoryImpl() {
	}

	public static synchronized CategoryRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new CategoryRepositoryImpl();
		}
		return instance;
	}

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
	public Collection<Category> getAll() {
		return storage.values();
	}

	@Override
	public Optional<Category> findByName(String name) {
		return storage.values().stream()
				.filter(category -> category.getName().equalsIgnoreCase(name))
				.findFirst();
	}

	@Override
	public List<Category> findByNameContaining(String keyword) {
		return storage.values().stream()
				.filter(category -> category.getName().toLowerCase().contains(keyword.toLowerCase()))
				.toList();
	}

	@Override
	public boolean existsByName(String name) {
		return storage.values().stream()
				.anyMatch(category -> category.getName().equalsIgnoreCase(name));
	}
}


