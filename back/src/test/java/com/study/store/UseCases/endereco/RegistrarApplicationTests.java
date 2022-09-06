package com.study.store.UseCases.endereco;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistrarApplicationTests {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void ShouldGetOnRoute() throws Exception{
        EnderecoMocked enderecoMocked = new EnderecoMocked();

		mockMvc.perform(post("/api/endereco/registrar")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString(enderecoMocked)))
		.andExpect(status().is(401));
        
    }

    @Test
    void ShouldSendInvalidProps() throws Exception{
        EnderecoMocked enderecoMocked = new EnderecoMocked();

        enderecoMocked.setCidade("");

		mockMvc.perform(post("/api/endereco/registrar")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString(enderecoMocked)))
		.andExpect(status().is(401))
        .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Informações inválidas"));
    }

    @Test
    void ShouldBadRequest() throws Exception{
        EnderecoMocked enderecoMocked = new EnderecoMocked();

        enderecoMocked.setCidade("");

		mockMvc.perform(post("/api/endereco/registrar")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString("")))
		.andExpect(status().is(400));
    }
}
