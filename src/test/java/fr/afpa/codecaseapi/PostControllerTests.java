package fr.afpa.codecaseapi;

import fr.afpa.codecaseapi.controller.PostController;
import fr.afpa.codecaseapi.model.Post;
import fr.afpa.codecaseapi.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * PostControllerTests
 * <i>de fr.afpa.codecaseapi</i>
 * <hr>
 * <p>Classe de tests pour la classe PostController</p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 2026/04/14
 */

@WebMvcTest(PostController.class)
public class PostControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private PostService postService;

  @Test
  public void testGetPosts() throws Exception {
    // Arrange — on définit ce que le mock retourne
    Post post = new Post();
    post.setContenuPost("test test test");
    when(postService.getPosts()).thenReturn(List.of(post));

    // Act & Assert
    mockMvc.perform(get("/posts"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].contenuPost", is("test test test")));
  }

  @Test
  public void testGetPostById() throws Exception {
    // Arrange
    Post post = new Post();
    post.setIdPost(1);  // int, pas Long
    when(postService.getPost(1)).thenReturn(Optional.of(post));

    // Act & Assert
    mockMvc.perform(get("/post/1"))
            .andDo(print())
            .andExpect(status().isOk());
  }
}
