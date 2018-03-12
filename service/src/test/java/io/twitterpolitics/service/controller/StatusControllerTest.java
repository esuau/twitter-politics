package io.twitterpolitics.service.controller;

import io.twitterpolitics.entity.Status;
import io.twitterpolitics.entity.User;
import io.twitterpolitics.service.service.StatusService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class StatusControllerTest {

    @Mock
    private StatusService statusService;

    @InjectMocks
    private StatusController statusController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(statusController).build();
    }

    @Test
    public void helloReturnsStatuses() throws Exception {
        List<Status> statuses = new ArrayList<>();
        statuses.add(new Status(1L, new Date(1L), "text1", new User(1L, "Evan Suau", "@evan_suau", "http://esuau.github.io")));
        statuses.add(new Status(2L, new Date(2L), "text2", new User(2L, "Noel Diril", "@noeldiril", "http://github.com")));
        when(statusService.findAll()).thenReturn(statuses);

        String expectedJSONString = "[{\"id\":1,\"createdAt\":1,\"text\":\"text1\",\"user\":{\"id\":1,\"name\":\"Evan Suau\",\"screenName\":\"@evan_suau\",\"profileImageUrl\":\"http://esuau.github.io\"}},{\"id\":2,\"createdAt\":2,\"text\":\"text2\",\"user\":{\"id\":2,\"name\":\"Noel Diril\",\"screenName\":\"@noeldiril\",\"profileImageUrl\":\"http://github.com\"}}]";

        mockMvc.perform(get("/statuses"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJSONString));
    }

}