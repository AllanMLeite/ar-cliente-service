package com.ar.clienteservice.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public Cliente incluir(Cliente cliente) {
		validarCliente(cliente);
		return repository.incluir(cliente);
	}

	private void validarCliente(Cliente cliente) {
		validarSituacaoCpf(cliente);
	}

	public void validarSituacaoCpf(Cliente cliente) {
		boolean isCpfValido = repository.consultarSituacaoCpf(cliente);
		if (!isCpfValido) throw new IllegalArgumentException("CPF com situacao irregular.");
	}
}
