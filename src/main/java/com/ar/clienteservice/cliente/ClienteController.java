package com.ar.clienteservice.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public ResponseEntity<String> incluirCliente(@RequestBody(required = true) String cpf) {
		
		Cliente cliente = service.incluir(new Cliente(cpf));
		
		return ResponseEntity.ok(String.valueOf(cliente.getId()));
	}
}
