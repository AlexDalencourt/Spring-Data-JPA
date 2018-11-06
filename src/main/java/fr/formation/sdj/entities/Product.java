package fr.formation.sdj.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = -816572441451992946L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "product")
    private List<Stock> stockLeft;

    @ManyToMany(mappedBy = "catalog")
    private List<Supplier> suppliers;

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(final List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public List<Stock> getStockLeft() {
        return stockLeft;
    }

    public void setStockLeft(final List<Stock> stockLeft) {
        this.stockLeft = stockLeft;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
