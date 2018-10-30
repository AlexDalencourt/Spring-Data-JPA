package fr.formation.sdj.repositories;

import fr.formation.sdj.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
}
