package lp3.backend.api;

import lp3.backend.model.Product;
import lp3.backend.service.ProductService;
import lp3.backend.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/lp3/product")
@RestController
public class ProductController {
    private final ProductService ProductService;
    @Autowired
    public ProductController(ProductService ProductService) {
        this.ProductService = ProductService;
    }
    @PostMapping
    public void addUser(@RequestBody Product Product){
        ProductService.addProduct(Product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return
                ProductService.getAllProducts();
    }

    @GetMapping(path = "{id}")
    public Product getProductById(@PathVariable("id") UUID id){
        return ProductService.getProductById(id)
                .orElse(null);
    }

//    @GetMapping(path = "{id}")
//    public Product getProductByName(@PathVariable("name") String name){
//        return ProductService.getProductByName(name)
//                .orElse(null);
//    }

    @DeleteMapping(path = "{id}")
    public void deleteProductById(@PathVariable("id") UUID id) {
        ProductService.deleteProduct(id);
    }

    @PutMapping(path = "{id}")
    public void updateProduct(@PathVariable("id") UUID id, @RequestBody Product ProductToUpdate){
        ProductService.updateProduct(id,ProductToUpdate);
    }
}