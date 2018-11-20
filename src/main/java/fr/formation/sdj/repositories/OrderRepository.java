package fr.formation.sdj.repositories;

import fr.formation.sdj.entities.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> getAllByOwnerName(String name);
}
