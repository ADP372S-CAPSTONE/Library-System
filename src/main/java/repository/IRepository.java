/* IRepository.java
   Generic repository interface
   Author: Tiyani Ngwana (231266731)
   Date: 13 March 2026.
*/
package repository;

import java.util.Collection;
import java.util.Optional;

public interface IRepository<T, ID> {
    T create(T t);
    Optional<T> read(ID id);
    T update(T t);
    boolean delete(ID id);
    Collection<T> getAll();
}


