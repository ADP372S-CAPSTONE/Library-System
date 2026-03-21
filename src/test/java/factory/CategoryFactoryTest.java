package factory;

import domain.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Category Factory Test.
//Author: Ngwana Tiyani 231266731.
//Date: 16 March 2026.

class CategoryFactoryTest {

    @Test
    void testCreateCategoryWithRequiredFields() {
        // This test will pass when factory is implemented 
        Category category = CategoryFactory.createCategory("C001", "Software Engineering");

        assertNotNull(category);
        assertEquals("C001", category.getCategoryId());
        assertEquals("Software Engineering", category.getName());
        assertNull(category.getDescription()); // Optional field should be null
    }

    @Test
    void testCreateCategoryWithAllFields() {
        Category category = CategoryFactory.createCategory(
                "C002",
                "Mobile Development",
                "Books about Android and iOS development"
        );

        assertNotNull(category);
        assertEquals("C002", category.getCategoryId());
        assertEquals("Mobile Development", category.getName());
        assertEquals("Books about Android and iOS development", category.getDescription());
    }

    @Test
    void testCreateCategoryWithInvalidId() {
        // Test with null ID - should throw exception
        assertThrows(IllegalArgumentException.class, () -> CategoryFactory.createCategory(null, "Web Development"));

        // Test with empty ID - should throw exception
        assertThrows(IllegalArgumentException.class, () -> CategoryFactory.createCategory("", "Web Development"));

        // Test with wrong format ID - should throw exception
        assertThrows(IllegalArgumentException.class, () -> CategoryFactory.createCategory("123", "Web Development"));
    }

    @Test
    void testCreateCategoryWithInvalidName() {
        // Test with null name - should throw exception
        assertThrows(IllegalArgumentException.class, () -> CategoryFactory.createCategory("C003", null));

        // Test with empty name - should throw exception
        assertThrows(IllegalArgumentException.class, () -> CategoryFactory.createCategory("C003", ""));
    }

    @Test
    void testGenerateCategoryId() {
        String id = CategoryFactory.generateCategoryId("C", 5);
        assertEquals("C005", id);
    }
}
