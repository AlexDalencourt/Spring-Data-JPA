package fr.formation.sdj.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -2535874741558061207L;
    @Id
    private String login;

    private String name;

    @OneToMany(mappedBy = "owner")
    private List<Order> orders;

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(final List<Order> orders) {
        this.orders = orders;
    }
}
