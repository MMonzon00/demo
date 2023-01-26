package lp3.backend.dao;

import lp3.backend.domain.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDao {
    int insertProduct (UUID id, Product Product);

    default int insertProduct(Product Product){
        UUID id = UUID.randomUUID();
        return insertProduct(id, Product);
    }

    List<Product> selectAllProducts();

    Optional<Product> selectProductById(UUID id);

//    Optional<Product> selectProductByName(String name);

    int deleteProductById(UUID id);

    int updateProductById(UUID id, Product Product);
}

