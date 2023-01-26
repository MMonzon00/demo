package lp3.backend.dao;

import lp3.backend.domain.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDao {
    int insertProduct (UUID id, Product Product);

    default void insertProduct(Product Product){
        UUID id = UUID.randomUUID();
        insertProduct(id, Product);
    }

    List<Product> selectAllProducts();

    Optional<Product> selectProductById(UUID id);

//    Optional<Product> selectProductByName(String name);

    void deleteProductById(UUID id);

    void updateProductById(UUID id, Product Product);
}

