package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.IVentaRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoCompras;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class VentaServiceImpl implements IVentaService {
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IVentaRepository ventaRepository;
	
	@Override
	public void insertar(Venta venta) {
		// TODO Auto-generated method stub
		this.ventaRepository.insertar(venta);
	}

	@Override
	public Venta buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.ventaRepository.buscar(id);
	}

	@Override
	public void actualizar(Venta venta) {
		// TODO Auto-generated method stub
		this.ventaRepository.actualizar(venta);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.ventaRepository.eliminar(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarVenta(List<ProductoCompras> listaProductos, String cedulaCliente, String numeroVenta) {
		// TODO Auto-generated method stub
		Producto producto = new Producto();
		Venta venta = new Venta();
		DetalleVenta detalleVenta = new DetalleVenta();
		List<DetalleVenta> detalles = new ArrayList<DetalleVenta>();
		
		for (ProductoCompras prodCompras : listaProductos) {
			producto = this.productoRepository.buscarPorCodigoBarras(prodCompras.getCodigoBarras());
			
			if(producto == null || producto.getStock() == 0) {
				throw new RuntimeException();
			}else if(prodCompras.getCantidad() <= producto.getStock()) {
				
				detalleVenta.setProducto(producto);
				detalleVenta.setCantidad(producto.getStock());
				detalleVenta.setPrecioUnitario(producto.getPrecio());
				detalleVenta.setSubtotal(new BigDecimal(detalleVenta.getCantidad()).multiply(producto.getPrecio()));
				detalles.add(detalleVenta);
			}
		}
		venta.setNumero(numeroVenta);
		venta.setFecha(LocalDateTime.now());
		venta.setCedulaCliente(cedulaCliente);
		venta.setDetalles(detalles);
	}

	@Override
	public List<Venta> buscarTodos() {
		// TODO Auto-generated method stub
		return this.ventaRepository.buscarTodos();
	}

}
