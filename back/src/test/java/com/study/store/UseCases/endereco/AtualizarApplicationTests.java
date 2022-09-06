package com.study.store.UseCases.endereco;

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
        EnderecoMocked enderecoMocked = new EnderecoMocked();

        enderecoMocked.setCidade("aaaa");

		mockMvc.perform(post("/api/endereco/atualizar")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString(enderecoMocked)))
		.andExpect(status().is(401))
        .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Informações inválidas"));
    }

    @Test
    void ShouldBadRequest() throws Exception{

		mockMvc.perform(post("/api/endereco/atualizar")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString("...")))
		.andExpect(status().is(400));
    }
}
