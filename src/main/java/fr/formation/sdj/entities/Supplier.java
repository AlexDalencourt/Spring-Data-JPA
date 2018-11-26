package fr.formation.sdj.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Supplier implements Serializable{

	private static final long serialVersionUID = 4319225091829692413L;

	@Id
    private String siret;

    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "supplier_catalog", joinColumns = @JoinColumn(name = "supplier_siret"), inverseJoinColumns = @JoinColumn(name = "catalog_id"))
    private List<Product> catalog;

    public List<Product> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<Product> catalog) {
        this.catalog = catalog;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
