/* Member.java
   Member domain class
   Author: Nxasana Owenkosi 230240887
*/
package domain;

import java.util.Objects;

// Member domain class
//Author: 230240887 Owenkosi Nxasana
//Date

public class Member {

    private final String memberID;
    private final String memberName;
    private final String memberEmail;
    private final String memberPhone;
    private final String membershipDate;

    private Member(Builder builder) {
        this.memberID = builder.memberID;
        this.memberName = builder.memberName;
        this.memberEmail = builder.memberEmail;
        this.memberPhone = builder.memberPhone;
        this.membershipDate = builder.membershipDate;
    }

    // Getters

    public String getMemberID() { return memberID; }
    public String getMemberName() { return memberName; }
    public String getMemberEmail() { return memberEmail; }
    public String getMemberPhone() { return memberPhone; }
    public String getMembershipDate() { return membershipDate; }

    @Override
    public String toString() {
        return "Member{" +
                "memberID='" + memberID + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", membershipDate='" + membershipDate + '\'' +
                '}';
    }

    // Builder Pattern
    public static class Builder {

        private final String memberID;
        private final String memberName;
        private String memberEmail;
        private String memberPhone;
        private String membershipDate;

        // Required fields constructor
        public Builder(String memberID, String memberName) {
            this.memberID = memberID;
            this.memberName = memberName;
        }

        public Builder setMemberEmail(String memberEmail) {
            this.memberEmail = memberEmail;
            return this;
        }

        public Builder setMemberPhone(String memberPhone) {
            this.memberPhone = memberPhone;
            return this;
        }

        public Builder setMembershipDate(String membershipDate) {
            this.membershipDate = membershipDate;
            return this;
        }

        public Member build() {

            if (memberID == null || memberID.trim().isEmpty()) {
                throw new IllegalArgumentException("ID is required");
            }

            if (!memberID.matches("^M\\d{3}$")) {
                throw new IllegalArgumentException("ID must be in format M001, M002, etc.");
            }

            if (memberName == null || memberName.trim().isEmpty()) {
                throw new IllegalArgumentException("Name is required");
            }

            if (memberEmail != null && !memberEmail.trim().isEmpty()
                    && !memberEmail.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
                throw new IllegalArgumentException("This email is invalid");
            }

            return new Member(this);
        }
    }
}