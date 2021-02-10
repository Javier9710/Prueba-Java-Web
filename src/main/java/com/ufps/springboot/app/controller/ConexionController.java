package com.ufps.springboot.app.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufps.springboot.app.models.entities.Conexion;
import com.ufps.springboot.app.models.entities.Historial;
import com.ufps.springboot.app.models.entities.TipoCifrado;
import com.ufps.springboot.app.models.service.IConexionService;

@Controller
@RequestMapping
public class ConexionController {

	@Autowired
	private IConexionService conexionServce;

	@GetMapping("/con/listar")
	public String listar(Model model) {

		List<Conexion> conexiones = conexionServce.findAll();

		model.addAttribute("titulo", "Listado de Conexiones");
		model.addAttribute("conexiones", conexiones);

		return "conexion/listar";

	}

	@GetMapping(value = "/con/form")
	public String crear(Map<String, Object> model) {

		List<TipoCifrado> tipos = conexionServce.findAllTipos();

		Conexion con = new Conexion();
		model.put("conexion", con);
		model.put("tipos", tipos);
		model.put("titulo", "Formulario de Conexiones");

		return "conexion/form";
	}

	@PostMapping("con/form")
	public String guardar(Conexion conexion, @RequestParam String tipoC, @RequestParam String tipoCon, RedirectAttributes flash) {

		String mensaje = (conexion.getId() != null) ? "Conexion Editada con exito" : "Conexion Creada con exito";

		TipoCifrado tipo = new TipoCifrado();
		tipo.setId(Long.parseLong(tipoC));
		conexion.setTipoCifrado(tipo);
		conexionServce.save(conexion);
		flash.addFlashAttribute("success", mensaje);
		return "redirect:listar";
	}

	@RequestMapping(value = "con/editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Conexion conexion = null;
		if (id > 0) {
			conexion = conexionServce.findOne(id);
			if (conexion == null) {
				flash.addFlashAttribute("error", "La conexion no Existe en la Base de Datos");
				return "redirect:/listar";

			}

		} else {
			return "redirect:/listar";

		}

		List<TipoCifrado> tipos = conexionServce.findAllTipos();
		System.out.println("-----" + conexion.getId());
		model.put("conexion", conexion);
		model.put("titulo", "Editar Conexion");
		model.put("tipos", tipos);

		return "conexion/form";
	}

	@RequestMapping(value = "/con/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			conexionServce.deleteById(id);
			flash.addFlashAttribute("success", "Se ha Eliminado con Exito");
		}

		return "redirect:/con/listar";
	}
	
	@GetMapping("con/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id,Model model, RedirectAttributes flash) {
		Conexion con = conexionServce.findOne(id);
		if (con==null) {
			flash.addFlashAttribute("error", "La Conexion no existe en la BD");
			return "redirect:../listar";
			
		}
		
		List<Historial> h = conexionServce.listasCon(id);
		
		model.addAttribute("historial", h);
		model.addAttribute("titulo", "Historial de Dispositivos");
		model.addAttribute("conexion", con);
		
		return "conexion/ver";
		
	}
}
