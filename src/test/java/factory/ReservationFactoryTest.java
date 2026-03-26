//Reservation Factory Test.
//Author:Abulele Ntwanambi 21827600
//Date:20/03/2026

package factory;


import domain.Reservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ReservationFactoryTest {

    @Test
    void shouldCreateReservation(){


        Reservation reservation = new Reservation.Builder("001",LocalDate.now( ),"Available")

                .setExpiryDate(LocalDate.now())
                .build();

        Assertions.assertEquals("001", reservation.getReservationID());
        Assertions.assertEquals(LocalDate.now(), reservation.getDate());
        Assertions.assertEquals("Available", reservation.getStatus());
        Assertions.assertEquals(LocalDate.now(), reservation.getExpiryDate());

    }

    @Test
    void MissingReservationID(){
        assertThrows(IllegalArgumentException.class,() ->{
            new Reservation.Builder("",LocalDate.now(),"Available").build();

        });
    }
    @Test
    void shouldShowAvailableStatus() {
        assertDoesNotThrow(() -> {
            new Reservation.Builder("001",LocalDate.now(),"Available")

                    .setExpiryDate(LocalDate.now())
                    .build();

        });
    }

    @Test
    void failWhenStatusIsEmpty(){
        assertThrows(IllegalArgumentException.class,()->{
            new Reservation.Builder("001",LocalDate.now(),"")

                    .setExpiryDate(LocalDate.now())
                    .build();
        });


    }


    @Test
    void shouldShowCurrentDate(){
        LocalDate date = LocalDate.now();
        Reservation reservation = new Reservation.Builder("001",LocalDate.now(),"Available")

                .setExpiryDate(LocalDate.now())
                .build();

        Assertions.assertEquals(date, reservation.getDate());
    }

    @Test
    void EmptyDate (){
        LocalDate date = LocalDate.now();
        Reservation reservation = new Reservation.Builder("001",LocalDate.now(),"Available")

                .setExpiryDate(LocalDate.now())
                .build();
    }

    @Test
    void shouldShowExpiryDate(){
        LocalDate expiryDate = LocalDate.now();
        Reservation reservation = new Reservation.Builder("001",LocalDate.now(),"Available")

                .setExpiryDate(LocalDate.now())
                .build();

        Assertions.assertEquals(expiryDate, reservation.getExpiryDate());

    }
}
