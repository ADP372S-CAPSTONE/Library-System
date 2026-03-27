/* Category Repository implementation Test
Author: Ngwana Tiyani 231266731
Date: 22 March 2026
*/
package repository.impl;

import domain.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRepositoryImplTest {

    @Test
    void testCreateReadUpdateDelete() {
        CategoryRepositoryImpl repository = CategoryRepositoryImpl.getInstance();

        Category category = new Category.Builder("C001", "Software Engineering").setDescription("SE books").build();
        repository.create(category);

        assertTrue(repository.read("C001").isPresent());

        Category updatedCategory = new Category.Builder("C001", "Software Engineering").setDescription("Updated description").build();
        repository.update(updatedCategory);
        assertTrue(repository.read("C001").isPresent());

        assertTrue(repository.delete("C001"));
        assertFalse(repository.read("C001").isPresent());
    }
}

