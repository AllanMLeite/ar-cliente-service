package com.ar.clienteservice.cliente;

import static org.assertj.core.api.Assertions.assertThatThrownBy; // main one
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void deveLancarExcecaoQuandoCpfForNulo() {
		assertThatThrownBy(() -> new Cliente(null)).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("CPF nao pode ser nulo.");
	}

	@Test
	public void deveLancarExcecaoQuandoCpfForVazio() {
		assertThatThrownBy(() -> new Cliente(" ")).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("CPF nao pode ser nulo.");
	}

	@Test
	public void deveCriarUmCliente() {
		String cpf = "01234567890";
		Cliente cliente = new Cliente(cpf);
		assertEquals(cpf, cliente.getCpf());
	}
}
