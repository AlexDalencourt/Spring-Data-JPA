package fr.formation.sdj.entities;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import fr.formation.sdj.entities.pk.StockPK;

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
    @ManyToOne(optional = true)
    private Supplier supplier;

    private Integer stockLeft;

    public Stock() {
        id = new StockPK();
    }

    public Stock(final StockPK id) {
        this.id = id;
    }
    
    public Stock(final StockPK id, Integer stockLeft) {
    	this(id);
    	this.stockLeft = stockLeft;
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

	@Override
	public String toString() {
		return "Stock [id=" + id + ", product=" + product + ", supplier=" + supplier + ", stockLeft=" + stockLeft + "]";
	}
}
