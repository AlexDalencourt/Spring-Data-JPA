package fr.formation.sdj.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

    private static final long serialVersionUID = 7813447036387376462L;
    @Id
    @GeneratedValue
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> detail;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(final User owner) {
        this.owner = owner;
    }

    public List<OrderDetail> getDetail() {
        return detail;
    }

    public void setDetail(final List<OrderDetail> detail) {
        this.detail = detail;
    }
}
