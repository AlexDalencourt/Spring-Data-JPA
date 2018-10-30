package fr.formation.sdj.repositories;

import fr.formation.sdj.entities.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier,String> {
}
