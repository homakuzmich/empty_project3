package controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import practice.Application;
import practice.controller.UserController;
import practice.service.UserService;
import practice.view.UserView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
@Transactional
@DirtiesContext
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
public class UserControllerTestDoesntWork {

    public UserControllerTestDoesntWork() {
    }

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @Test
    public void test_list_all() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/list")
                .accept(MediaType.ALL_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.USER").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.USER[*].id").isNotEmpty());
       /* UserView firstUser=new UserView(1L,"Иван","Николаев","Иванович","Руководитель","(499)240-11-10",true,"3");
        UserView secondUser=new UserView(2L,"Жанна","Иванова","Сергеевна","Управляющая","(499)240-1102)",true,"3");

        List<UserView> users= new ArrayList<>();
        users.add(firstUser);
        users.add(secondUser);
        assertThat(users,hasSize(2));
        userService.addAndSave(firstUser);
        userService.addAndSave(secondUser);
        users=userService.users();
        when(userService.users()).thenReturn(users);
        mockMvc.perform(get("/user/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[0].firstName",is("Иванов")))
                .andExpect(jsonPath("$[1].id",is(2)))
                .andExpect(jsonPath("$[1].firstName",is("Поляков")));
        verify(userService, times(1)).users();
        verifyNoMoreInteractions(userService);
        */
    }

    @Test
    public void loadByIdTest() throws Exception {
        UserView pol = new UserView(1L, "Сергей", "Николаев", "Иванович", "Руководитель", "(499)240-11-10", true, "3");

        when(userService.loadById(pol, 1L)).thenReturn(pol);

        mockMvc.perform(get("/user/{id}", 1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].user.id", is(1)))
                .andExpect(jsonPath("$[0].user.firstName", is("Сергей")));
        verify(userService, times(1)).loadById(pol, 1L);
        verifyNoMoreInteractions(userService);
    }
}
