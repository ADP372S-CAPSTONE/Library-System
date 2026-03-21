/* CategoryFactory.java
   Category factory class
   Author: Tiyani Ngwana 231266731
   Date: 16 March 2026
*/
package factory;

import domain.Category;

public class CategoryFactory {
    public static Category createCategory(String categoryId, String name) {
        return new Category.Builder(categoryId, name)
                .build();
    }

    // Factory method with ALL fields
    public static Category createCategory(String categoryId, String name, String description) {
        return new Category.Builder(categoryId, name)
                .setDescription(description)
                .build();
    }

    // Helper method to generate next Category ID (optional utility)
    public static String generateCategoryId(String prefix, int number) {
        return String.format("%s%03d", prefix, number); // e.g., C001
    }


}
