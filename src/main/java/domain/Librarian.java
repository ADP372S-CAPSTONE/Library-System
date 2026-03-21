/* Librarian.java
   Librarian domain class.
   Author: Sinethemba Nyimbinya (220085870).
   Date: 16 March 2026.
*/
package domain;

import java.util.Objects;

//Librarian domain class
//Author:
//Date: 16 March 2026

public class Librarian{
    private String StaffId;
    private String name;
    private String email;
    private String number;

    private Librarian(Builder builder){
        this.StaffId = builder.StaffId;
        this.name = builder.name;
        this.email = builder.email;
        this.number = builder.number;

    }
    public String getStaffId(){
        return StaffId;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getNumber(){
        return number;
    }

    public static class Builder{
        private String StaffId;
        private String name;
        private String email;
        private String number;

        public Builder setLibrarianId(String StaffId){
            this.StaffId = StaffId;
            return this;
        }
        public Builder  setName(String name){
            this.name = name;
            return this;
        }
        public Builder setEmail(String email){
            this.email = email;
            return this;
        }
        public Builder setNumber(String number) {
            this.number = number;
            return this;
        }

        public Librarian build(){
            return new Librarian(this);
        }

    }
}
