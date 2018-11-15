package com.ar.clienteservice.cliente;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClienteService service;

	@Test
	public void deveLancarExcecaoQuandoCpfNaoForInformado() throws Exception {
		this.mockMvc.perform(post("/cliente").content(StringUtils.EMPTY)).andExpect(status().isBadRequest());
	}

	@Test
	public void deveIncluirCliente() throws Exception {

		Cliente clienteIncluido = new Cliente("01237890");
		clienteIncluido.setId(1L);
		Mockito.doReturn(clienteIncluido).when(service).incluir(Mockito.any(Cliente.class));

		this.mockMvc.perform(post("/cliente").content("\"cpf\":\"01234567890\"")).andExpect(status().isOk())
				.andExpect(content().string(containsString("1")));
		;
	}
}
