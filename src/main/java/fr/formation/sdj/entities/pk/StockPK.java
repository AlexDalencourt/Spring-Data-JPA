package fr.formation.sdj.entities.pk;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StockPK implements Serializable {

    private static final long serialVersionUID = -4091653634973810267L;

    private Integer productId;

    private String supplierId;

    public StockPK() {
    }

    public StockPK(final Integer productId, final String supplierId) {
        this.productId = productId;
        this.supplierId = supplierId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(final String supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(final Integer productId) {
        this.productId = productId;
    }
}
