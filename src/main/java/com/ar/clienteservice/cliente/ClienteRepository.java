package com.ar.clienteservice.cliente;

public interface ClienteRepository {

	Cliente incluir(Cliente cliente);

	boolean consultarSituacaoCpf(Cliente cliente);

}
