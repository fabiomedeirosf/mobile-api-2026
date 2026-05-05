package br.fatec.aulaapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.aulaapi.dto.Cliente;

@RestController
public class ClienteController {

	private static List<Cliente> listaClientes = new ArrayList<>();
	
	@PostMapping(path = "/clientes")
	public ResponseEntity<?> postCliente(@RequestBody Cliente novoCliente) {
		//cliente existe: lanca-se o erro (valida pelo email 1 cliente 1 email)
		if(existeCliente(novoCliente.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("cliente já existe");
		}
		
		int codigo = (int) (Math.random() * 1000);
		novoCliente.setCodigo(codigo);
		listaClientes.add(novoCliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
	}
	
	private boolean existeCliente(String email) {
		Cliente clienteProcurado = null;
		for(Cliente c : listaClientes) {
			if(c.getEmail().equals(email)) {
				clienteProcurado = c;
			}
		}
		
		if(clienteProcurado == null) {
			return false;
		} else {
			return true;
		}
	}
}
