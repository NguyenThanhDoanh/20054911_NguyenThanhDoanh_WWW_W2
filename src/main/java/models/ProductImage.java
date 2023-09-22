package models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_images")
public class ProductImage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;


    @Id
    @ManyToOne()
    @JoinColumn(name="product_id")
    private Product product;




    @Column(name = "path")
    private String path;

    @Column(name = "alternative")
    private String alternative;

    // Constructors, getters, and setters

    public ProductImage() {
    }

    public ProductImage(Long imageId, Product product, String path, String alternative) {
        this.imageId = imageId;
        this.product = product;
        this.path = path;
        this.alternative = alternative;
    }

// Getters and setters


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "imageId=" + imageId +
                ", product=" + product +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }
}