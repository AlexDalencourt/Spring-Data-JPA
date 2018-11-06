package fr.formation.sdj.repositories;

import fr.formation.sdj.entities.PK.StockPK;
import fr.formation.sdj.entities.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, StockPK> {
}
