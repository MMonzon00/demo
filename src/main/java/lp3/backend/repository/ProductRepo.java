package lp3.backend.repository;

import lp3.backend.dao.ProductDao;
import lp3.backend.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository("ProductDao")
public class ProductRepo implements ProductDao {

    private final static List<Product> productDB = new ArrayList<>();


    @Override
    public int insertProduct(UUID id, Product Product){
        productDB.add(new Product(id, Product.getName(),Product.getWeight(), Product.getType(), Product.getPrice()));
        return 0;
    }

    @Override
    public List<Product> selectAllProducts() {
        return productDB;
    }

    @Override
    public Optional<Product> selectProductById(UUID id) {
        return productDB.stream()
                .filter(Product -> Product.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteProductById(UUID id) {
        Optional<Product> ProductMaybe = selectProductById(id);
        if (ProductMaybe.isEmpty()) {
            return;
        }
        productDB.remove(ProductMaybe.get());
    }


    @Override
    public void updateProductById(UUID id, Product update) {
        selectProductById(id)
                .map(Product -> {
                    int indexOfProductToUpdate = productDB.indexOf(Product);
                    if (indexOfProductToUpdate >= 0) {
                        productDB.set(indexOfProductToUpdate, new Product(id, update.getName(), update.getWeight(), update.getType(), update.getPrice()));
                        return 1;
                    }
                    return 0;
                });
    }
}
