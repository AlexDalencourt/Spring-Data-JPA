package fr.formation.sdj.repositories;

import fr.formation.sdj.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer>{
}
