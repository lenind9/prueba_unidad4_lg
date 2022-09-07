package com.uce.edu.demo.repository.modelo;

public class ProductoSencillo {
	
	private String codigoBarras;
	private String nombre;
	private String categoria;
	private Integer stock;
	
	public ProductoSencillo() {
		
	}

	public ProductoSencillo(String codigoBarras, String nombre, String categoria, Integer stock) {
		super();
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.categoria = categoria;
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "ProductoSencillo [codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", categoria=" + categoria
				+ ", stock=" + stock + "]";
	}

	//SET y GET
	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
