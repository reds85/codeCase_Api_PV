package fr.afpa.codecaseapi.service;

import fr.afpa.codecaseapi.model.Post;
import fr.afpa.codecaseapi.repository.PostRepository;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PostService
 * <i>de fr.afpa.codecaseapi.service</i>
 * <hr>
 * <p>Service pour appliquer les traitements métier de Post</p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 2026/04/09
 */

@Data
@Service
public class PostService {
  // Le Repository de Post.
  @Autowired
  private PostRepository postRepository;

  /**
   * Méthode getPost.
   *
   *<i>de PostService</i>
   *<hr>
   *<p>Va chercher tous les Posts dans la table</p>
   * @return Un Iterable composé de Posts
   */
  public Iterable<Post> getPosts(){
    return postRepository.findAll();
  }

  /**
   * Méthode getPost.
   *
   *<i>de PostService</i>
   *<hr>
   *<p>Prends un id et renvoie le Post en question s'il existe</p>
   * @param id l'id du post cherché
   * @return Un optional de Posts
   */
  public Optional<Post> getPost(int id){
    return  postRepository.findById(id);
  }

  /**
   * Méthode savePost.
   *
   *<i>de PostService</i>
   *<hr>
   *<p>Prends un Objet Post et le sauvegarde ou le mets à jour dans la BDD</p>
   * @param post le Post à créer ou modifier
   * @return Le Post créé ou modifié
   */
  public Post savePost(Post post){
    return postRepository.save(post);
  }

  /**
   * Méthode deletePost.
   *
   *<i>de PostService</i>
   *<hr>
   *<p>Prends l'id d'un Post et le supprime</p>
   * @param id L'id du Post à supprimer
   */
  public void deletePost(int id){
    postRepository.deleteById(id);
  }
}
