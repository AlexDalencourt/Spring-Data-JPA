package fr.formation.sdj.entities;

import fr.formation.sdj.entities.PK.OrderDetailPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

@Entity
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 4655043604341008907L;
    @EmbeddedId
    private OrderDetailPK id;

    @MapsId("productId")
    @ManyToOne
    private Product product;

    @MapsId("orderId")
    @ManyToOne
    private Order order;

    private Integer quantity;

    public OrderDetailPK getId() {
        return id;
    }

    public void setId(final OrderDetailPK id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(final Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }
}
