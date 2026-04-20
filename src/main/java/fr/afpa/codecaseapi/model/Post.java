package fr.afpa.codecaseapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import lombok.Data;

/**
 * Post
 * <i>de fr.afpa.codecaseapi.model</i>
 * <hr>
 * <p>Modèle Post, lié à JPA</p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 2026/04/09
 */

@Data
@Entity
@Table(name = "post")
public class Post {
  /**
   * Variable id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idPost")
  private Integer idPost;

  /**
   * Variable titre.
   */
  @Size(min = 3, max = 100)
  @Column(name = "titrePost")
  private String titrePost;

  /**
   * Variable description.
   */
  @Size(max = 250)
  @Column(name = "descriptionPost")
  private String descriptionPost;

  /**
   * Variable contenu.
   */
  @NotEmpty()
  @Column(name = "contenuPost")
  private String contenuPost;

  /**
   * Variable userId.
   */
  @ManyToOne()
  @JoinColumn(name = "idUser")
  private User idUser;

  /**
   * Variable language de type Tag.
   */
  @ManyToOne()
  @JoinColumn(name = "idTag")
  private Tag idTag;

  /**
   * Variable tagCustom, dans une Arraylist de type Tag.
   */
//  @ManyToMany(mappedBy = "post")
//  List<Tag> tagCustom;

  /**
   * Variable creationPost.
   */
  @Column(name = "dateCreation")
  private LocalDate dateCreation;

}
