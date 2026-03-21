/* IRepository.java
   Generic repository interface
   Author: Tiyani Ngwana (231266731)
   Date: 13 March 2026
*/
package repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, ID> {
    T create(T entity);

    Optional<T> read(ID id);

    T update(T entity);

    boolean delete(ID id);

    List<T> findAll();
}

