package factory;

import domain.Publisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Publisher Factory Test.
//Author: Ngwana Tiyani 231266731.
//Date: 16 March 2026.

class PublisherFactoryTest {

    @Test
    void testCreatePublisherWithRequiredFields() {
        Publisher publisher = PublisherFactory.createPublisher("P001", "Pearson");

        assertNotNull(publisher);
        assertEquals("P001", publisher.getPublisherID());
        assertEquals("Pearson", publisher.getPublisherName());
        assertNull(publisher.getPublisherAddress());
        assertNull(publisher.getPublisherEmail());
        assertNull(publisher.getPublisherPhone());
    }

    @Test
    void testCreatePublisherWithAllFields() {
        Publisher publisher = PublisherFactory.createPublisher(
                "P002",
                "O'Reilly Media",
                "1005 Gravenstein Highway North, Sebastopol, CA",
                "info@oreilly.com",
                "123-456-7890"
        );

        assertNotNull(publisher);
        assertEquals("P002", publisher.getPublisherID());
        assertEquals("O'Reilly Media", publisher.getPublisherName());
        assertEquals("1005 Gravenstein Highway North, Sebastopol, CA", publisher.getPublisherAddress());
        assertEquals("info@oreilly.com", publisher.getPublisherEmail());
        assertEquals("123-456-7890", publisher.getPublisherPhone());
    }

    @Test
    void testCreatePublisherWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> PublisherFactory.createPublisher(null, "Pearson"));
        assertThrows(IllegalArgumentException.class, () -> PublisherFactory.createPublisher("", "Pearson"));
        assertThrows(IllegalArgumentException.class, () -> PublisherFactory.createPublisher("123", "Pearson"));
    }

    @Test
    void testCreatePublisherWithInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> PublisherFactory.createPublisher("P003", null));
        assertThrows(IllegalArgumentException.class, () -> PublisherFactory.createPublisher("P003", ""));
    }

    @Test
    void testCreatePublisherWithInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> PublisherFactory.createPublisher(
                "P004",
                "Pearson",
                "Address",
                "invalid-email",
                "1234567890"
        ));
    }

    @Test
    void testGeneratePublisherId() {
        String id = PublisherFactory.generatePublisherId(7);
        assertEquals("P007", id);
    }
}
