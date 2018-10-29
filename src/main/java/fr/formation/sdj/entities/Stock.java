package fr.formation.sdj.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Stock implements Serializable{

    @EmbeddedId
    private StockPK id;

    @MapsId("productId")
    @ManyToOne
    private Product product;

    @MapsId("supplierId")
    @ManyToOne
    private Supplier supplier;

    private Integer stockLeft;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Integer getStockLeft() {
        return stockLeft;
    }

    public void setStockLeft(Integer stockLeft) {
        this.stockLeft = stockLeft;
    }

    public StockPK getId() {
        return id;
    }

    public void setId(StockPK id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Embeddable
    public class StockPK implements Serializable{

        private Integer productId;

        private String supplierId;

        public String getSupplierId() {
            return supplierId;
        }

        public void setSupplierId(String supplierId) {
            this.supplierId = supplierId;
        }

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }
    }
}
