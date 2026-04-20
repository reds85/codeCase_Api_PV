package fr.afpa.codecaseapi.repository;

import fr.afpa.codecaseapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * UserRepository.
 * <i>de fr.afpa.codecaseapi.repository</i>
 * <hr>
 * <p>Interface CRUD pour USER</p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 2026/04/08
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmailUser(String emailUser);
}
