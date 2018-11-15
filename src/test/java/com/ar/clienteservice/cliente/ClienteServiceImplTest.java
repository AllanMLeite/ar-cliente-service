package com.ar.clienteservice.cliente;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceImplTest {

	@InjectMocks
	private ClienteServiceImpl service;

	@Mock
	private ClienteRepository repo;

	@Test
	public void deveLancarExcecaoQuandoCpfIrregular() {
		Mockito.doReturn(false).when(repo).consultarSituacaoCpf(Mockito.any(Cliente.class));

		assertThatThrownBy(() -> service.incluir(new Cliente("01234567890")))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("CPF com situacao irregular.");
	}
	
	@Test
	public void deveIncluirCliente() {
		Cliente clienteMockado = new Cliente("01234567890");
		clienteMockado.setId(1L);
		Mockito.doReturn(clienteMockado).when(repo).incluir(Mockito.any(Cliente.class));
		Mockito.doReturn(true).when(repo).consultarSituacaoCpf(Mockito.any(Cliente.class));

		Cliente clienteIncluido = service.incluir(new Cliente("01234567890"));
		assertNotNull(clienteIncluido.getId());
	}
}
