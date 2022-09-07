package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.ProductoCompras;

public interface IGestorSupermercadoService {
	
	public void realizarVenta(List<ProductoCompras> productos, String cedulaCliente, String numeroVenta);
	public void reporteVentas(LocalDateTime fechaVenta, String categoriaProducto, Integer cantidad);
}
