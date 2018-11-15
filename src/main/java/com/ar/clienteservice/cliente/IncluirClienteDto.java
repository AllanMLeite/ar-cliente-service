package com.ar.clienteservice.cliente;

import javax.validation.constraints.NotBlank;

public class IncluirClienteDto {

	@NotBlank(message = "CPF nao pode ser nulo")
	private String cpf;

	public String getCpf() {
		return cpf;
	}
}
