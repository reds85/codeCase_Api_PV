package fr.afpa.codecaseapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

/**
 * User.
 * <i>de fr.afpa.codecaseapi.model</i>
 * <hr>
 * <p>Model User, liée à JPA pour la modélisation de la BDD</p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 2026/04/07
 */
@Data
@Entity
@Table(name = "utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Integer idUser;

    @Column(name = "pseudoUser")
    @Size(min = 3, max = 20)
    private String pseudoUser;

    @Column(name = "passwordUser")
    @NotBlank
    private String passwordUser;

    @Column(name = "signupDateUser")
    @NotNull
    private LocalDate signupDateUser;

    @Column(name = "lastSignInUser")
    @NotNull
    private LocalDate lastSignInUser;

    @Column(name = "emailUser")
    @Size(min = 8, max = 150)
    private String emailUser;

    @Column(name = "avatarUser")
    private String avatarUser;

    @Column(name = "Role")
    @NotBlank
    @Size(max = 50)
    private String role;
}
