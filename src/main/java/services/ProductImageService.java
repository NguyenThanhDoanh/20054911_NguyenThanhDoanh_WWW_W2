package services;

import models.ProductImage;
import repositories.ProductImageRepository;

import java.util.List;

public class ProductImageService {

    private final ProductImageRepository ProductImageDao;

    public ProductImageService() {
        ProductImageDao = new ProductImageRepository(ProductImage.class);
    }

    public void createProductImage(ProductImage ProductImage) {
        ProductImageDao.create(ProductImage);
    }

    public void updateProductImage(ProductImage ProductImage) {
        ProductImageDao.update(ProductImage);
    }

    public boolean deleteProductImage(int ProductImageId) {
        ProductImage ProductImage = ProductImageDao.findById(ProductImageId);
        if (ProductImage != null) {
            ProductImageDao.delete(ProductImage);
            return true;
        }
        return false;
    }

    public ProductImage getProductImageById(int ProductImageId) {
        return ProductImageDao.findById(ProductImageId);
    }

    public List<ProductImage> getAllProductImages() {
        return ProductImageDao.findAll();
    }

}
