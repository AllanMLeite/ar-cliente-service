package com.ar.clienteservice.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
	
	private static final String ENDPOINT_SITUACAO_CPF = "http://ar-validador-comum-service/situacao/cpf";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

	@Override
	public Cliente incluir(Cliente cliente) {
		cliente.setId(1L);
		return cliente;
	}

	@Override
	public boolean consultarSituacaoCpf(Cliente cliente) {
		ResponseEntity<String> isSituacaoCpfValido = restTemplate.postForEntity(ENDPOINT_SITUACAO_CPF, cliente, String.class);
		return Boolean.valueOf(isSituacaoCpfValido.getBody());
	}
}
