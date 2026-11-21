package uk.ac.westminster.products_api;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    void save(Product product);
    boolean delete(Long id);
}
