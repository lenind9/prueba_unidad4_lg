package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;

public interface IProductoRepository {
	public void insertar(Producto producto);
	public Producto buscar(Integer id);
	public void actualizar(Producto producto);
	public void eliminar(Integer id);
	
	public Producto buscarPorCodigoBarras(String codigoBarras);
	public ProductoSencillo buscarProdSencillo(String codigoBarras);
	
	public List<Producto> buscarTodos();
}
