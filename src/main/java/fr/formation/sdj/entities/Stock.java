package fr.formation.sdj.entities;

import fr.formation.sdj.entities.PK.StockPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

@Entity
public class Stock implements Serializable {

    private static final long serialVersionUID = 7099217719598142717L;
    @EmbeddedId
    private StockPK id;

    @MapsId("productId")
    @ManyToOne
    private Product product;

    @MapsId("supplierId")
    @ManyToOne
    private Supplier supplier;

    private Integer stockLeft;

    public Stock() {
        id = new StockPK();
    }

    public Stock(final StockPK id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(final Supplier supplier) {
        this.supplier = supplier;
    }

    public Integer getStockLeft() {
        return stockLeft;
    }

    public void setStockLeft(final Integer stockLeft) {
        this.stockLeft = stockLeft;
    }

    public StockPK getId() {
        return id;
    }

    public void setId(final StockPK id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }
}
