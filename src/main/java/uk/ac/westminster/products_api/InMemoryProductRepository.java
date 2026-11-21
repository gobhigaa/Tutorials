package uk.ac.westminster.products_api;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository{

    private final Map<Long, Product> store = new HashMap<>();
    private Long nextId = 1L;

    public InMemoryProductRepository() {
        save(new DigitalProduct(
                null, "Clean code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2
        ));
    }

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            product.setId(nextId);
            nextId++;
        }
        store.put(product.getId(), product);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public boolean delete(Long id) {
        boolean flag = store.containsKey(id);
        store.remove(id);
        return flag;
    }
}
