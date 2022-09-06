package com.study.store.UseCases.loja;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BuscarApplicationTests {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void ShouldReturnContentTypeInvalid() throws Exception{
        LojaMocked produtoMocked = new LojaMocked();

        produtoMocked.setNome("");

		mockMvc.perform(post("/api/loja/buscar")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString(produtoMocked)))
		.andExpect(status().is(405));
    }

}
