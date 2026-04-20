package fr.afpa.codecaseapi.repository;

import fr.afpa.codecaseapi.model.Post;
import fr.afpa.codecaseapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * PostRepository
 *<i>de fr.afpa.codecaseapi.repository</i>
 *<hr>
 *<p>Interface CRUD pour Post</p>
 *
 *@author Calderoli Alexandre
 *@version 0.0.1
 *@since 2026/04/09
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

}
