package com.ar.clienteservice.cliente;

import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

	@Override
	public Cliente incluir(Cliente cliente) {
		cliente.setId(1L);
		return cliente;
	}

	@Override
	public boolean consultarSituacaoCpf(Cliente cliente) {
		// TODO Auto-generated method stub
		return true;
	}
}
