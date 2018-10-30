package fr.formation.sdj.repositories;

import fr.formation.sdj.entities.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Stock.StockPK> {
}
