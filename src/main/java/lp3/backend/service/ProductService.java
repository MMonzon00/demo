package lp3.backend.service;

import lp3.backend.dao.ProductDao;
import lp3.backend.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductDao ProductDao;
    @Autowired
    public ProductService(@Qualifier("ProductDao") ProductDao ProductDao) {
        this.ProductDao = ProductDao;
    }

    public void addProduct(Product Product){
        ProductDao.insertProduct(Product);
    }

    public List<Product> getAllProducts(){
        return ProductDao.selectAllProducts();
    }

    public Optional<Product> getProductById(UUID id){
        return ProductDao.selectProductById(id);
    }

    public void deleteProduct(UUID id){
        ProductDao.deleteProductById(id);
    }

    public void updateProduct(UUID id, Product newProduct) {
        ProductDao.updateProductById(id, newProduct);
    }
}

