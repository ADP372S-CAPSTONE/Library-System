package repository.impl;

import domain.Loan;
import repository.LoanRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LoanRepositoryImpl implements LoanRepository {

	private final Map<String, Loan> storage = new HashMap<>();

	private String keyFor(Loan loan) {
		return String.valueOf(loan.hashCode());
	}

	@Override
	public Loan create(Loan entity) {
		storage.put(keyFor(entity), entity);
		return entity;
	}

	@Override
	public Optional<Loan> read(String id) {
		return Optional.ofNullable(storage.get(id));
	}

	@Override
	public Loan update(Loan entity) {
		storage.put(keyFor(entity), entity);
		return entity;
	}

	@Override
	public boolean delete(String id) {
		return storage.remove(id) != null;
	}

	@Override
	public List<Loan> findAll() {
		return new ArrayList<>(storage.values());
	}
}
