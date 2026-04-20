package fr.afpa.codecaseapi.controller;

import fr.afpa.codecaseapi.exception.ExceptionManager;
import fr.afpa.codecaseapi.model.User;
import fr.afpa.codecaseapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

/**
 * UserController
 * <i>de fr.afpa.codecaseapi.controller</i>
 * <hr>
 * <p>Controller REST pour les endpoints User</p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 2026/04/08
 */
@RestController
public class
UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        try{
            System.out.println(user.toString());
            return ResponseEntity.ok(userService.saveUser(user));
        } catch (Exception e) {
            return ExceptionManager.handleException(e);
        }

    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getUsers(){
        try{
            return ResponseEntity.ok(userService.getUsers());
        }catch (Exception e) {
            return ExceptionManager.handleException(e);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        try{
            Optional<User> user = userService.getUser(id);
            if (user.isPresent()){
                return ResponseEntity.ok(user.get());
            }else{
                return new ResponseEntity("User non présent", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            return ExceptionManager.handleException(e);
        }
    }

    @GetMapping("/userMail/{email}")
    public ResponseEntity<User> getUserByMail(@PathVariable("email") String email){
        try{
            Optional<User> user = userService.getUserByEmail(email);
            if (user.isPresent()){
                return ResponseEntity.ok(user.get());
            }else{
                return new ResponseEntity("User non présent", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            return ExceptionManager.handleException(e);
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user){

        try{
            Optional<User> temp = userService.getUser(id);

            if(temp.isPresent()){
                User current = temp.get();

                String pseudo = user.getPseudoUser();
                String pass = user.getPasswordUser();
                String email = user.getEmailUser();
                String avatar = user.getAvatarUser();
                String role = user.getRole();//
                LocalDate signUp = user.getSignupDateUser();
                LocalDate last = user.getLastSignInUser();

                current.setPseudoUser(pseudo != null ? pseudo : current.getPseudoUser());

                if (pass != null){
                    current.setPasswordUser(pass);
                }

                if (email != null){
                    current.setEmailUser(email);
                }

                if (avatar != null){
                    current.setAvatarUser(avatar);
                }

                if (role != null){
                    current.setRole(role);
                }

                if (signUp != null){
                    current.setSignupDateUser(signUp);
                }

                if (last != null){
                    current.setLastSignInUser(last);
                }
                userService.saveUser(current);
                return ResponseEntity.ok(current);
            }else {
                return new ResponseEntity("User non présent", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return ExceptionManager.handleException(e);
        }
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.ok("User supprimé");
        }catch (Exception e){
            return ExceptionManager.handleException(e);
        }
    }

}
