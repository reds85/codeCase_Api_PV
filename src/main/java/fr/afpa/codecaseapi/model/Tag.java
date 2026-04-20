package fr.afpa.codecaseapi.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
/**
 * Tag
 * <i>de fr.afpa.codecaseapi.model</i>
 * <hr>
 * <p>Modèle Tag, lié à JPA</p>
 *
 * @author Loïc RICHARD
 * @version 0.0.1
 * @since 2026/04/13
 */
@Data
@Entity
@Table(name = "Tags")
public class Tag {
  /**
   * Variable ID.
   */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "idTag")
    private Integer idTag;

  /**
   * Variable intitulé
   */
  @Size(min = 3, max = 30)
  @NotEmpty()
  @Column(name ="intituleTag")
  private String intituleTag;
}

