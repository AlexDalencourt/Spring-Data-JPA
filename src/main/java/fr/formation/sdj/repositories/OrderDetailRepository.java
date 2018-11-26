package fr.formation.sdj.repositories;

import fr.formation.sdj.entities.OrderDetail;
import fr.formation.sdj.entities.pk.OrderDetailPK;

import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, OrderDetailPK> {
}
