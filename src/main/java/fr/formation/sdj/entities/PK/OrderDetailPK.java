package fr.formation.sdj.entities.PK;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailPK implements Serializable {

    private static final long serialVersionUID = -2420673796033797814L;

    private Integer productId;

    private Integer orderId;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final OrderDetailPK that = (OrderDetailPK) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId, orderId);
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(final Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(final Integer orderId) {
        this.orderId = orderId;
    }
}
