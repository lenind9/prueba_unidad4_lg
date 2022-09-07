package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.Venta;
import com.uce.edu.demo.service.IVentaService;

@Controller
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
	private IVentaService ventaService;
	
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Venta> lista = this.ventaService.buscarTodos();
		modelo.addAttribute("ventas", lista);
		return "valorListaVenta";
	}
	
}
