package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Venta;

public interface IVentaRepository {
	public void insertar(Venta venta);
	public Venta buscar(Integer id);
	public void actualizar(Venta venta);
	public void eliminar(Integer id);
	
	public List<Venta> buscarTodos();
}
