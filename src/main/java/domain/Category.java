/* Category.java
   Category domain class.
   Author: Ngwana Tiyani 231266731.
   Date: 16 March 2026.
*/
package domain;


public class Category {

    private final String categoryId;
    private final String name;
    private final String description;


    private Category(Builder builder) {
        this.categoryId = builder.categoryId;
        this.name = builder.name;
        this.description = builder.description;
    }

    // Getters
    public String getCategoryId() { return categoryId; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId='" + categoryId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    // BUILDER PATTERN
    public static class Builder {
        public String publisherID;
        public String publisherName;
        public String publisherEmail;
        public String publisherPhone;
        public String publisherAddress;
        private final String categoryId;
        private final String name;
        private String description;

        // Constructor
        public Builder(String categoryId, String name) {
            this.categoryId = categoryId;
            this.name = name;
        }


        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        // BUILD method with VALIDATION
        public Category build() {
            // Validate required fields
            if (categoryId == null || categoryId.trim().isEmpty()) {
                throw new IllegalArgumentException("Category ID is required");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Category name is required");
            }
            // Category ID format validation (C001, C002, etc.)
            if (!categoryId.matches("^C\\d{3}$")) {
                throw new IllegalArgumentException("Category ID must be in format C001, C002, etc.");
            }
            return new Category(this);
        }
    }


}
