package fr.afpa.codecaseapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
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

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testGetPosts() throws Exception{
    mockMvc.perform(get("/posts"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].contenuPost",
            is("test test test")));
  }

  @Test
  public void testGetPostById() throws Exception{
    mockMvc.perform(get("/post/1"))
        .andDo(print())
        .andExpect(status().isOk());
  }

//  @Test
//  public void testCreatePost() throws Exception{
//    mockMvc.perform(post("/post"))
//        .andDo(print())
//        .andExpect(status().isOk());
//  }

//  @Test
//  public void testDelete() throws Exception{
//    mockMvc.perform(delete("/post/1"))
//        .andExpect(status().isOk());
//  }
}
