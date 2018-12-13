package fr.formation.sdj.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.formation.sdj.entities.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier,String> {
	
	List<Supplier> findAllByCatalog_Id(Integer productId);
}
