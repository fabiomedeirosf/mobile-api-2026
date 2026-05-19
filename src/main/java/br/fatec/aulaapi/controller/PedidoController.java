package br.fatec.aulaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.aulaapi.dto.Pedido;

@RestController
public class PedidoController {

	@PostMapping(path = "/pedidos")
	public ResponseEntity<?> postPedido(@RequestBody Pedido pedido) {
		
		//TODO: validacao: pedido tem que ter item
		//nao pode ter ter item repetido
		
		//gera um codigo para o pedido
		int codigo = (int) (Math.random() * 1000);
		pedido.setCodigo(codigo);
		
		//TODO: armazenar lista na memoria
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
		
	}
}
