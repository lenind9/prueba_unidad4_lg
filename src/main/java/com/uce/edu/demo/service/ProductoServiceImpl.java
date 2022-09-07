package com.uce.edu.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;

@Service
public class ProductoServiceImpl implements IProductoService {

	private static Logger LOG = Logger.getLogger(ProductoServiceImpl.class);

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepository.insertar(producto);
	}

	@Override
	public void ingresarProducto(Producto producto) {
		// TODO Auto-generated method stub
		Producto prod = this.productoRepository.buscarPorCodigoBarras(producto.getCodigoBarras());

		if (prod == null) {
			this.productoRepository.insertar(producto);
		} else {
			prod.setStock(prod.getStock() + producto.getStock());
			this.productoRepository.actualizar(prod);
		}

	}

	@Override
	public ProductoSencillo consultarStock(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.productoRepository.buscarProdSencillo(codigoBarras);
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return this.productoRepository.buscarTodos();
	}

}
