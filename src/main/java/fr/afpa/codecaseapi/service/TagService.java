package fr.afpa.codecaseapi.service;

import fr.afpa.codecaseapi.model.Tag;
import fr.afpa.codecaseapi.repository.TagRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <h1>TagService</h1>
 * <hr>
 * <p>
 * Service pour appliquer les traitements métier de Tag
 * </p>
 *
 * @author loicrichard
 * @version 0.O.1
 * @since 2026/04/13
 */

@Data
@Service
public class TagService {
    // Le repository de Tag
    @Autowired
    private TagRepository tagRepository;

    /** Méthode getTags
     * <i>de TagService</i>
     * <hr>
     * <p>Va chercher tous les tags dans la table</p>
     * @return un Iterable composé de tags
     */

    public Iterable<Tag> getTags() {
        return tagRepository.findAll();
    }

    /** Méthode getTag
     *
     * <i>de TagService</i>
     * <hr>
     * <p>Affiche en tag en fonction de son id</p>
     * @param id l'id du tag cherché
     * @return Un optional de Tags
     */

    public Optional<Tag> getTag(Integer id) {
        return tagRepository.findById(id);
    }

    /**
     * Méthode saveTag
     *
     * <i>de TagService</i>
     * <hr>
     * <p>Crée ou Modifie un tag dans la base de données</p>
     * @param tag le tag à créer ou modifier
     * @return le taf créé ou modifier
     */

    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    /**
     * Méthode deleteTag
     *
     * <i>de TagService</i>
     * <hr>
     * <p>Supprime un tag en fonction de son id</p>
     * @param id l'id du tag à supprimer
     */

    public void deleteTag(Integer id) {
        tagRepository.deleteById(id);
    }
}
