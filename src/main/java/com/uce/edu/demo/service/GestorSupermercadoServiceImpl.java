package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoCompras;

@Service
public class GestorSupermercadoServiceImpl implements IGestorSupermercadoService {
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IVentaService ventaService;

	@Override
	public void realizarVenta(List<ProductoCompras> productos, String cedulaCliente, String numeroVenta) {
		// TODO Auto-generated method stub
		Producto producto = new Producto();
		DetalleVenta detalle = new DetalleVenta();
		List<DetalleVenta> detalles = new ArrayList<DetalleVenta>();
		Integer cantidad = 0;
		BigDecimal subtotal = BigDecimal.ZERO;
		BigDecimal total = BigDecimal.ZERO;
		
		for(ProductoCompras prod : productos) {
			producto = this.productoRepository.buscarPorCodigoBarras(prod.getCodigoBarras());
			cantidad = prod.getCantidad();

			if(producto.getStock() == 0 || producto == null) {
				throw new RuntimeException();
			}

			if(cantidad > producto.getStock()) {
				cantidad = producto.getStock();
			}
			detalle.setProducto(producto);
			detalle.setCantidad(cantidad);
			producto.setStock(producto.getStock() - cantidad);
			
			this.productoRepository.actualizar(producto);
			
			detalle.setPrecioUnitario(producto.getPrecio());
			subtotal = producto.getPrecio().multiply(new BigDecimal(cantidad));
			detalle.setSubtotal(subtotal);
			total.add(subtotal);
			detalles.add(detalle);
		}
		
		this.ventaService.realizarVenta(productos, cedulaCliente, numeroVenta);

	}
	
	@Override
	public void reporteVentas(LocalDateTime fechaVenta, String categoriaProducto, Integer cantidad) {
		// TODO Auto-generated method stub
		
	}
	
}
