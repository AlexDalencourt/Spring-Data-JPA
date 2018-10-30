package fr.formation.sdj.repositories;

import fr.formation.sdj.entities.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Stock.StockPK> {
}
