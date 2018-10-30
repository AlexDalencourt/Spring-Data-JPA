package fr.formation.sdj.repositories;

import fr.formation.sdj.entities.OrderDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail,OrderDetail.OrderDetailPK> {
}
