package com.study.store.UseCases.produto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

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
        ProdutoMocked produtoMocked = new ProdutoMocked();

		mockMvc.perform(post("/api/produto/registrar")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString(produtoMocked)))
		.andExpect(status().is(400));
        
    }

    @Test
    void ShouldSendInvalidProps() throws Exception{
        ProdutoMocked produtoMocked = new ProdutoMocked();

        produtoMocked.setNome("");

		mockMvc.perform(post("/api/produto/registrar")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString(produtoMocked)))
		.andExpect(status().is(401))
        .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Informações inválidas"));
    }

    @Test
    void ShouldBadRequest() throws Exception{
        ProdutoMocked produtoMocked = new ProdutoMocked();

        produtoMocked.setNome("");

		mockMvc.perform(post("/api/produto/registrar")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString("")))
		.andExpect(status().is(400));
    }
}
