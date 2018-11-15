package com.ar.clienteservice.cliente;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClienteRepositoryImplTest {

	@InjectMocks
	private ClienteRepositoryImpl repo;

	@Test
	public void deveIncluirCliente() {
		Cliente clienteIncluido = repo.incluir(new Cliente("01234567890"));
		assertNotNull(clienteIncluido.getId());
	}
}
