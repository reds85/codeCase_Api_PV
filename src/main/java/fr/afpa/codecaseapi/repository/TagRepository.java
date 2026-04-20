package fr.afpa.codecaseapi.repository;

import fr.afpa.codecaseapi.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>TagRepository</h1>
 * <hr>
 * <p>
 * Interface CRUD pour Tag
 * </p>
 *
 * @author loic richard
 * @version 0.0.1
 * @since 2026/04/13
 */
@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
}
