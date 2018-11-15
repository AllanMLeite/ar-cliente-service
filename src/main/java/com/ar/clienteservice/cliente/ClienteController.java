package com.ar.clienteservice.cliente;

import javax.validation.Valid;

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
	public ResponseEntity<String> incluirCliente(@RequestBody @Valid IncluirClienteDto dto) {
		
		Cliente cliente = service.incluir(new Cliente(dto.getCpf()));
		
		return ResponseEntity.ok(String.valueOf(cliente.getId()));
	}
}
