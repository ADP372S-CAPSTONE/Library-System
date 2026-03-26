/* ReservationRepositoryImplTest.java
   Reservation repository implementation test
   Author: Abulele Ntwanambi (218276400)
   Date: 22 March 2026
*/
package repository.impl;

import domain.Reservation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ReservationRepositoryImplTest {

    @Test
    void testCreate() {
        ReservationRepositoryImpl repository = ReservationRepositoryImpl.getInstance();
        Reservation reservation = new Reservation.Builder("R001", LocalDate.now(), "Available")
                .setExpiryDate(LocalDate.now().plusDays(2))
                .build();

        Reservation createdReservation = repository.create(reservation);

        assertNotNull(createdReservation);
        assertEquals("R001", createdReservation.getReservationID());
        assertEquals("Available", createdReservation.getStatus());
    }

    @Test
    void testRead() {
        ReservationRepositoryImpl repository = ReservationRepositoryImpl.getInstance();
        Reservation reservation = new Reservation.Builder("R002", LocalDate.now(), "Pending")
                .setExpiryDate(LocalDate.now().plusDays(3))
                .build();

        repository.create(reservation);
        String key = reservation.getReservationID();

        Optional<Reservation> foundReservation = repository.read(key);

        assertTrue(foundReservation.isPresent());
        assertEquals("R002", foundReservation.get().getReservationID());
    }

    @Test
    void testUpdate() {
        ReservationRepositoryImpl repository = ReservationRepositoryImpl.getInstance();
        Reservation reservation = new Reservation.Builder("R003", LocalDate.now(), "Available")
                .setExpiryDate(LocalDate.now().plusDays(2))
                .build();

        repository.create(reservation);
        String key = reservation.getReservationID();

        Reservation updatedReservation = new Reservation.Builder("R003", LocalDate.now(), "Collected")
                .setExpiryDate(LocalDate.now().plusDays(2))
                .build();

        repository.update(updatedReservation);

        Optional<Reservation> result = repository.read(key);
        assertTrue(result.isPresent());
        assertEquals("Collected", result.get().getStatus());
    }

    @Test
    void testDelete() {
        ReservationRepositoryImpl repository = ReservationRepositoryImpl.getInstance();
        Reservation reservation = new Reservation.Builder("R004", LocalDate.now(), "Available")
                .setExpiryDate(LocalDate.now().plusDays(2))
                .build();

        repository.create(reservation);
        String key = reservation.getReservationID();

        boolean deleted = repository.delete(key);

        assertTrue(deleted);
        assertFalse(repository.read(key).isPresent());
    }

    @Test
    void testGetAll() {
        ReservationRepositoryImpl repository = ReservationRepositoryImpl.getInstance();
        Reservation reservation1 = new Reservation.Builder("R005", LocalDate.now(), "Available")
                .setExpiryDate(LocalDate.now().plusDays(2))
                .build();

        Reservation reservation2 = new Reservation.Builder("R006", LocalDate.now(), "Pending")
                .setExpiryDate(LocalDate.now().plusDays(3))
                .build();

        repository.create(reservation1);
        repository.create(reservation2);

        Collection<Reservation> allReservations = repository.getAll();

        assertNotNull(allReservations);
        assertTrue(allReservations.size() >= 2);
    }
}

