import com.fasterxml.jackson.databind.ObjectMapper;
import com.iguan.todo.controller.ToDoController;
import com.iguan.todo.dto.ToDoDTO;
import com.iguan.todo.service.ToDoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


@SpringBootTest(classes = {ToDoController.class})
@AutoConfigureMockMvc
public class ToDoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoService toDoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllToDos() throws Exception {
        when(toDoService.getAllToDos(anyInt(), anyInt()))
                .thenReturn(new PageImpl<>(Collections.singletonList(new ToDoDTO())));

        mockMvc.perform(MockMvcRequestBuilders.get("/todos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetToDoById() throws Exception {
        when(toDoService.getToDoById(anyInt())).thenReturn(new ToDoDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/todos/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testAddToDo() throws Exception {

        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setName("Test ToDo");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(toDoDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testUpdateToDo() throws Exception {
        ToDoDTO toDoDTO = new ToDoDTO();
      //  toDoDTO.setId(1);
        toDoDTO.setName("Test ToDo");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(toDoDTO);

        when(toDoService.updateTodoFields(any(ToDoDTO.class))).thenReturn(toDoDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/todos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDeleteToDo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/todos/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        verify(toDoService, times(1)).deleteToDo(1);
    }
}
