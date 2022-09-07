package com.uce.edu.demo.repository.modelo;

public class ProductoCompras {
	
	private String codigoBarras;
	private Integer cantidad;
	
	public ProductoCompras() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductoCompras(String codigoBarras, Integer cantidad) {
		super();
		this.codigoBarras = codigoBarras;
		this.cantidad = cantidad;
	}
	
	//SET y GET
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
