package services;

import models.ProductPrice;
import repositories.ProductPriceRepository;

import java.util.List;

public class ProductPriceService {

    private final ProductPriceRepository ProductPriceDao;

    public ProductPriceService() {
        ProductPriceDao = new ProductPriceRepository(ProductPrice.class);
    }

    public void createProductPrice(ProductPrice ProductPrice) {
        ProductPriceDao.create(ProductPrice);
    }

    public void updateProductPrice(ProductPrice ProductPrice) {
        ProductPriceDao.update(ProductPrice);
    }

    public boolean deleteProductPrice(int ProductPriceId) {
        ProductPrice ProductPrice = ProductPriceDao.findById(ProductPriceId);
        if (ProductPrice != null) {
            ProductPriceDao.delete(ProductPrice);
            return true;
        }
        return false;
    }

    public ProductPrice getProductPriceById(int ProductPriceId) {
        return ProductPriceDao.findById(ProductPriceId);
    }

    public List<ProductPrice> getAllProductPrices() {
        return ProductPriceDao.findAll();
    }

}
