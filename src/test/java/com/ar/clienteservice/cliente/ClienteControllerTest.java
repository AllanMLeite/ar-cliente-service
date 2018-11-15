package com.ar.clienteservice.cliente;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

	private static final String ENDPOINT_CLIENTE = "/cliente";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClienteService service;

	@Test
	public void deveLancarExcecaoQuandoCpfNaoForInformado() throws Exception {
		this.mockMvc.perform(post(ENDPOINT_CLIENTE).content("{\"cpf\":\"\"}").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void deveIncluirCliente() throws Exception {

		Cliente clienteIncluido = new Cliente("01237890");
		clienteIncluido.setId(354L);
		Mockito.doReturn(clienteIncluido).when(service).incluir(Mockito.any(Cliente.class));

		this.mockMvc
				.perform(post(ENDPOINT_CLIENTE).content("{\"cpf\":\"01234567890\"}").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(containsString("354")));
	}
	
	@Test
	public void	deveTratarExcecaoDoTipoIllegalArgumentException() throws Exception {
		Mockito.doThrow(new IllegalArgumentException("Mensagem 123")).when(service).incluir(Mockito.any(Cliente.class));

		this.mockMvc
				.perform(post(ENDPOINT_CLIENTE).content("{\"cpf\":\"01234567890\"}").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest()).andExpect(content().string(containsString("Mensagem 123")));
	}
}
