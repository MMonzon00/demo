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

    private static List<Product> DB = new ArrayList<>();

    @Override
    public int insertProduct(UUID id, Product Product){
        DB.add(new Product(id, Product.getName(),Product.getWeight(), Product.getType()));
        return 0;
    }

    @Override
    public List<Product> selectAllProducts() {
        return DB;
    }

    @Override
    public Optional<Product> selectProductById(UUID id) {
        return DB.stream()
                .filter(Product -> Product.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteProductById(UUID id) {
        Optional<Product> ProductMaybe = selectProductById(id);
        if (ProductMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(ProductMaybe.get());
        return 1;
    }


    @Override
    public int updateProductById(UUID id, Product update) {
        return selectProductById(id)
                .map(Product -> {
                    int indexOfProductToUpdate = DB.indexOf(Product);
                    if (indexOfProductToUpdate >= 0){
                        DB.set(indexOfProductToUpdate, new Product(id, update.getName(), update.getWeight(), Product.getType()));
                        return 1;
                    }
                    return 0;
                } )
                .orElse(0);
    }
}
