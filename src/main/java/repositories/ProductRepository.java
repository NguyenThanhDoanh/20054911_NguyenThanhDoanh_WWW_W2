package repositories;


import models.Product;

public class ProductRepository  extends  CRUD_GENERIC<Product>{


    public ProductRepository(Class<Product> cus) {
        super(cus);
    }




}
