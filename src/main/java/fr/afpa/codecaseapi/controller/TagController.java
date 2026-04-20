package fr.afpa.codecaseapi.controller;

import fr.afpa.codecaseapi.exception.ExceptionManager;
import fr.afpa.codecaseapi.model.Post;
import fr.afpa.codecaseapi.model.Tag;
import fr.afpa.codecaseapi.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * <h1>TagController</h1>
 * <hr>
 * <p>
 * Controller REST pour les endpoints Tag
 * </p>
 *
 * @author loicrichard
 * @version 0.0.1
 * @since 2026/04/13
 */

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/tag")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
       try {
           return ResponseEntity.ok(tagService.saveTag(tag));
       } catch (Exception e) {
           return ExceptionManager.handleException(e);
       }
    }

    @GetMapping("/tags")
    public ResponseEntity<Iterable<Tag>> getTags() {
        try {
            return ResponseEntity.ok(tagService.getTags());
        } catch (Exception e) {
            return ExceptionManager.handleException(e);
        }
    }

    @GetMapping("/tag/{id}")
    public ResponseEntity<Tag> getTag(@PathVariable("id") Integer id) {
        try {
            Optional<Tag> tag = tagService.getTag(id);
            if (tag.isPresent()) {
                return ResponseEntity.ok(tag.get());
            } else  {
                return new ResponseEntity("Tag non présent",
                HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ExceptionManager.handleException(e);
        }
    }

    @PutMapping("/tag/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable("id") Integer id,
                                         @RequestBody Tag tag) {
        try {
            Optional<Tag> temp = tagService.getTag(id);
            if (temp.isPresent()) {
                Tag current = temp.get();

                String intitule = tag.getIntituleTag();
                current.setIntituleTag(intitule != null ? intitule : current.getIntituleTag());

            tagService.saveTag(current);
            return ResponseEntity.ok(current);
        } else {
            return new ResponseEntity("Tag non présent",
            HttpStatus.NOT_FOUND);
        }
    } catch (Exception e) {
        return ExceptionManager.handleException(e);
    }
}

@DeleteMapping("tag/{id}")
public ResponseEntity<String> deleteTag(@PathVariable("id") Integer id) {
    try {
        tagService.deleteTag(id);
        return ResponseEntity.ok("Tag supprimé");
    } catch (Exception e) {
        return ExceptionManager.handleException(e);
    }
}
}
