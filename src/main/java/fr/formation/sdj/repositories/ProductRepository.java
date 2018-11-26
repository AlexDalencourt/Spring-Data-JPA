package fr.formation.sdj.repositories;

import fr.formation.sdj.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAllByName(String name);
    
    int countByNameLike(String pattern);
}
