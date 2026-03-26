/* PublisherFactory.java
   Publisher factory class
   Author: Ngwana Tiyani 231266731
   Date: 16 March 2026
*/
package factory;

import domain.Publisher;

public class PublisherFactory {

    public static Publisher createPublisher(String publisherId, String name) {
        return new Publisher.Builder(publisherId, name)
                .build();
    }

    public static Publisher createPublisher(String publisherId, String name, String address, String email, String phone) {
        return new Publisher.Builder(publisherId, name)
                .setPublisherAddress(address)
                .setPublisherEmail(email)
                .setPublisherPhone(phone)
                .build();
    }

    public static String generatePublisherId(int number) {
        return String.format("P%03d", number);
    }
}
