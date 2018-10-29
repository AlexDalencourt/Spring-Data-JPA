package fr.formation.sdj.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class OrderDetail implements Serializable {

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

    public void setId(OrderDetailPK id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Embeddable
    public class OrderDetailPK implements Serializable {

        private Integer productId;

        private Integer orderId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            OrderDetailPK that = (OrderDetailPK) o;
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

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public Integer getOrderId() {
            return orderId;
        }

        public void setOrderId(Integer orderId) {
            this.orderId = orderId;
        }
    }
}
