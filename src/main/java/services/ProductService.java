package services;

import models.Product;
import repositories.ProductRepository;

import java.util.List;

public class ProductService {

    private final ProductRepository ProductDao;

    public ProductService() {
        ProductDao = new ProductRepository(Product.class);
    }

    public void createProduct(Product Product) {
        ProductDao.create(Product);
    }

    public void updateProduct(Product Product) {
        ProductDao.update(Product);
    }

    public boolean deleteProduct(long ProductId) {
        Product Product = ProductDao.findById(ProductId);
        if (Product != null) {
            ProductDao.delete(Product);
            return true;
        }
        return false;
    }

    public Product getProductById(int ProductId) {
        return ProductDao.findById(ProductId);
    }

    public List<Product> getAllProducts() {
        return ProductDao.findAll();
    }

}
