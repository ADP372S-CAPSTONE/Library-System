package repository.impl;

import domain.Reservation;
import repository.ReservationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ReservationRepositoryImpl implements ReservationRepository {

	private final Map<String, Reservation> storage = new HashMap<>();

	@Override
	public Reservation create(Reservation entity) {
		storage.put(entity.getReservationID(), entity);
		return entity;
	}

	@Override
	public Optional<Reservation> read(String id) {
		return Optional.ofNullable(storage.get(id));
	}

	@Override
	public Reservation update(Reservation entity) {
		storage.put(entity.getReservationID(), entity);
		return entity;
	}

	@Override
	public boolean delete(String id) {
		return storage.remove(id) != null;
	}

	@Override
	public List<Reservation> findAll() {
		return new ArrayList<>(storage.values());
	}
}
