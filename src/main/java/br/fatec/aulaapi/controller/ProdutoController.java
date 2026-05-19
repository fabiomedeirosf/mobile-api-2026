package br.fatec.aulaapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.aulaapi.dto.Produto;
import br.fatec.aulaapi.repository.ProdutoRepository;
import jakarta.websocket.server.PathParam;

@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	private static final List<Produto> listaProdutos = new ArrayList<Produto>();

	@PostMapping(path="/produtos")
	public ResponseEntity<?> postProduto(@RequestBody Produto novoProduto) {
		
		//validação
		if(novoProduto.getDescricao() == null ||
				novoProduto.getDescricao().isEmpty() ||
				novoProduto.getDescricao().length() <= 3) {
			
			return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body("Descrição inválida");
		}
		
		//salva no bd
		Produto p = this.produtoRepository.save(novoProduto);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
	
	@GetMapping(path = "/produtos/{codigo}")
	public ResponseEntity<?> getById(@PathVariable(name = "codigo") 
									 Integer codigo) {
		
		Produto produtoProcurado = 
				this.produtoRepository.findById(codigo).get();
		
		if(produtoProcurado == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(produtoProcurado);
		}
	}
	
	@GetMapping(path = "/produtos")
	public List<Produto> getProdutos() {
		
		return this.produtoRepository.findAll();
	}
	
	@DeleteMapping(path = "/produtos/{codigo}")
	public ResponseEntity<?> deleteById(@PathVariable(name="codigo") Integer codigo) {
		
		Produto produtoProcurado = 
				listaProdutos
				.stream()
				.filter(p -> p.getCodigo().equals(codigo))
				.findFirst()
				.orElse(null);
		
		listaProdutos.remove(produtoProcurado);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	
	@PutMapping(path = "/produtos/{codigo}")
	public ResponseEntity<?> putProduto(@PathVariable(name = "codigo") Integer codigo, 
									    @RequestBody Produto produtoAlterado) {
		
		//procura-se o produto pelo codigo (path)
		Produto produtoProcurado = 
				listaProdutos
				.stream()
				.filter(p -> p.getCodigo().equals(codigo))
				.findFirst()
				.orElse(null);
		
		//se o produto nao existe
		if(produtoProcurado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao existe");
		}
		
		listaProdutos.remove(produtoProcurado);
		
		produtoAlterado.setCodigo(codigo);
		listaProdutos.add(produtoAlterado);
		
		return ResponseEntity.status(HttpStatus.OK).body(produtoAlterado);
	}
	
	
}
