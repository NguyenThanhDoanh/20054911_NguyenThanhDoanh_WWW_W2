package repositories;

import models.Product;
import models.ProductImage;

public class ProductImageRepository  extends  CRUD_GENERIC<ProductImage>{


    public ProductImageRepository(Class<ProductImage> cus) {
        super(cus);
    }




}
