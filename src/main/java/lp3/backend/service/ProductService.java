package lp3.backend.service;

import lp3.backend.dao.ProductDao;
import lp3.backend.model.Product;
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

    public int addProduct(Product Product){
        return ProductDao.insertProduct(Product);
    }

    public List<Product> getAllProducts(){
        return ProductDao.selectAllProducts();
    }

    public Optional<Product> getProductById(UUID id){
        return ProductDao.selectProductById(id);
    }

    public int deleteProduct(UUID id){
        return ProductDao.deleteProductById(id);
    }

    public int updateProduct(UUID id, Product newProduct) {
        return ProductDao.updateProductById(id, newProduct);
    }
}

