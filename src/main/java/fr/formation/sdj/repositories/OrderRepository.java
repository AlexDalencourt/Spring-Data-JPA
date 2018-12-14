package fr.formation.sdj.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.formation.sdj.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> getAllByOwnerName(String name);
    
    List<Order> findAllByDateBetweenOrderByDateDesc(Date dateAfter, Date dateBefore);
}
