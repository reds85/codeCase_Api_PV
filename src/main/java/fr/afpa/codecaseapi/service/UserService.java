package fr.afpa.codecaseapi.service;

import fr.afpa.codecaseapi.model.User;
import fr.afpa.codecaseapi.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * UserService.
 * <i>de fr.afpa.codecaseapi.service</i>
 * <hr>
 * <p>Service pour appliquer les traitements métier de User</p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 2026/04/08
 */
@Data
@Service
public class UserService {

    // Le Repository de User.
    @Autowired
    private UserRepository userRepository;

    /**
     * Méthode getUsers.
     *
     *<i>de UserService</i>
     *<hr>
     *<p>Va chercher tous les Users dans la table</p>
     * @return Un Iterable composé de Users
     */
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    /**
     * Méthode getUser.
     *
     *<i>de UserService</i>
     *<hr>
     *<p>Prends une id et renvoie le User en question s'il existe</p>
     * @param id l'id du User cherché
     * @return Un optional de Users
     */
    public Optional<User> getUser(int id){
        return  userRepository.findById(id);
    }

    /**
     * Méthode getUserByEmail.
     *
     *<i>de UserService</i>
     *<hr>
     *<p>Prends un email et renvoie le User en question s'il existe</p>
     * @param email le email du User cherché
     * @return Un optional de Users
     */
    public Optional<User> getUserByEmail(String email){
        return  userRepository.findByEmailUser(email);
    }

    /**
     * Méthode saveUser.
     *
     *<i>de UserService</i>
     *<hr>
     *<p>Prends un Objet User et le sauvegarde ou le mets à jour dans la BDD</p>
     * @param user le User à créer ou modifier
     * @return Le User créé ou modifié
     */
    public User saveUser(User user){
        return userRepository.save(user);
    }

    /**
     * Méthode deleteUser.
     *
     *<i>de UserService</i>
     *<hr>
     *<p>Prends l'id d'un User et le supprime</p>
     * @param id L'id du User à delete
     */
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

}
