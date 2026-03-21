/* Publisher.java
   Publisher domain class.
   Author: Ngwana Tiyani 231266731.
   Date: 13 March 2026.
*/
package domain;

public class Publisher {
    private final String publisherID;
    private final String publisherName;
    private final String publisherEmail;
    private final String publisherPhone;
    private final String publisherAddress;

    private Publisher(Builder builder) {
        this.publisherID = builder.publisherID;
        this.publisherName = builder.publisherName;
        this.publisherEmail = builder.publisherEmail;
        this.publisherPhone = builder.publisherPhone;
        this.publisherAddress = builder.publisherAddress;
    }

    //Getters

    public String getPublisherID() { return publisherID; }
    public String getPublisherName() { return publisherName; }
    public String getPublisherEmail() { return publisherEmail; }
    public String getPublisherPhone() { return publisherPhone; }
    public String getPublisherAddress() { return publisherAddress; }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherID='" + publisherID + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", publisherEmail='" + publisherEmail + '\'' +
                ", publisherPhone='" + publisherPhone + '\'' +
                ", publisherAddress='" + publisherAddress + '\'' +
                '}';
    }

    // Builder pattern used by factory methods.
    public static class Builder {
        private final String publisherID;
        private final String publisherName;
        private String publisherEmail;
        private String publisherPhone;
        private String publisherAddress;

        public Builder(String publisherID, String publisherName) {
            this.publisherID = publisherID;
            this.publisherName = publisherName;
        }

        public Builder setPublisherEmail(String publisherEmail) {
            this.publisherEmail = publisherEmail;
            return this;
        }

        public Builder setPublisherPhone(String publisherPhone) {
            this.publisherPhone = publisherPhone;
            return this;
        }

        public Builder setPublisherAddress(String publisherAddress) {
            this.publisherAddress = publisherAddress;
            return this;
        }

        public Publisher build() {
            if (publisherID == null || publisherID.trim().isEmpty()) {
                throw new IllegalArgumentException("Publisher ID is required");
            }
            if (!publisherID.matches("^P\\d{3}$")) {
                throw new IllegalArgumentException("Publisher ID must be in format P001, P002, etc.");
            }
            if (publisherName == null || publisherName.trim().isEmpty()) {
                throw new IllegalArgumentException("Publisher name is required");
            }
            if (publisherEmail != null && !publisherEmail.trim().isEmpty()
                    && !publisherEmail.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
                throw new IllegalArgumentException("Publisher email is invalid");
            }
            return new Publisher(this);
        }
    }
}
