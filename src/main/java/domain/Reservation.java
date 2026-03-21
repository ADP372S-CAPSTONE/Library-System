/* Reservation.java

*/
//Reservation domain class
//Author: Abulele Ntwanambi 218276400
//Date: 16 March 2026.

package domain;


import java.time.LocalDate;
import java.util.Objects;

public class Reservation
{
    private String reservationID;;
    private LocalDate date;
    private String status;
    private LocalDate expiryDate;


    public Reservation(Builder builder){
        this.reservationID = builder.reservationID;
        this.date = builder.date;
        this.status = builder.status;
        this.expiryDate = builder.expiryDate;
    }
    public String toString(){
        String reserveInfo =
                "Reservation" + " " + reservationID + " "+
                        "Local Date" + date + " " + "Status" + " " + status + "" + "Expiry Date" + expiryDate;

        return reserveInfo;
    }

    public String getReservationID() {return reservationID;}

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getExpiryDate() {return expiryDate;}

    public static class Builder{
        private String reservationID;
        private LocalDate date;
        private String status;
        private LocalDate expiryDate;


        public Builder(String reservationID, LocalDate date, String status){
            this.reservationID = reservationID;
            this.date = date;
            this.status = status;

        }
        public Builder setExpiryDate(LocalDate expiryDate){
            this.expiryDate = expiryDate;
            return this;

        }


        public  Reservation build(){
            //VALIDATION FOR REQUIRED ATTRIBUTES
            if(reservationID == null || reservationID.isEmpty()){
                throw new  IllegalArgumentException("Reservation ID required");
            }
            if(date == null){
                throw new IllegalArgumentException("Date required");
            }
            if(status == null || status.isEmpty()){
                throw new IllegalArgumentException("Status is required");
            }
            return new Reservation(this);

        }
    }



}


