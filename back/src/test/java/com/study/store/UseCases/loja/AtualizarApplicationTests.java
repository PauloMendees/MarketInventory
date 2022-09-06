package com.study.store.UseCases.loja;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AtualizarApplicationTests {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void ShouldSendInvalidCredentials() throws Exception{
        LojaMocked lojaMocked = new LojaMocked();

        lojaMocked.setNome("aaaa");

		mockMvc.perform(post("/api/loja/atualizar")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString(lojaMocked)))
		.andExpect(status().is(401))
        .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Informações inválidas"));
    }

    @Test
    void ShouldBadRequest() throws Exception{

		mockMvc.perform(post("/api/loja/atualizar")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString("...")))
		.andExpect(status().is(400));
    }
}
