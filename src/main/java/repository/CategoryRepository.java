/* CategoryRepository.java
   Category repository interface
   Author: Abulele Ntwanambi (218276400)
   Date: 13 March 2026
*/
package repository;

import domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends IRepository<Category, String> {
    // Additional query methods specific to Category
    Optional<Category> findByName(String name);
    List<Category> findByNameContaining(String keyword);
    boolean existsByName(String name);
}