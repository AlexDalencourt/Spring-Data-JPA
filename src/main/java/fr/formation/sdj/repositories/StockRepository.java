package fr.formation.sdj.repositories;

import fr.formation.sdj.entities.Stock;
import fr.formation.sdj.entities.pk.StockPK;

import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, StockPK> {
}
