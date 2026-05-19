package br.fatec.aulaapi.dto;

import java.util.List;

public class Pedido {

	private Integer codigo;
	
	private String tipo;
	
	private Cliente cliente;
	
	private List<Produto> items;
	
	private Double total;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getItems() {
		return items;
	}

	public void setItems(List<Produto> items) {
		this.items = items;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
