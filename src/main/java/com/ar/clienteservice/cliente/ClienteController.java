package com.ar.clienteservice.cliente;

import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public ResponseEntity<Cliente> incluirCliente(@RequestBody @Valid IncluirClienteDto dto) {
		Cliente cliente = service.incluir(new Cliente(dto.getCpf()));
		return ResponseEntity.ok(cliente);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleException(Exception exception) {
		return ResponseEntity.badRequest().body(Collections.singletonMap("message", exception.getMessage()));
	}
}
