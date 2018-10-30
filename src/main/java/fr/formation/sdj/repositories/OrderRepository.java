package fr.formation.sdj.repositories;

import fr.formation.sdj.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
