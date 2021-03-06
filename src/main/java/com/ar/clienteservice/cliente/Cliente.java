package com.ar.clienteservice.cliente;

import org.apache.commons.lang3.StringUtils;

public class Cliente {
	
	private Long id;

	private String cpf;

	public Cliente(String cpf) {

		if (StringUtils.isBlank(cpf))
			throw new IllegalArgumentException("CPF nao pode ser nulo.");
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
