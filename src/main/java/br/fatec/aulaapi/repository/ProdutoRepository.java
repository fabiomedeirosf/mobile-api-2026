package br.fatec.aulaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.aulaapi.dto.Produto;


public interface ProdutoRepository 
			extends JpaRepository<Produto, Integer> {

}
