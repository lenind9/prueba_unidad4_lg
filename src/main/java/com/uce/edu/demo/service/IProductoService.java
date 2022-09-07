package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;

public interface IProductoService {
	public void insertar(Producto producto);
	
	public void ingresarProducto(Producto producto);
	public ProductoSencillo consultarStock(String codigoBarras);
	
	public List<Producto> buscarTodos();
}
