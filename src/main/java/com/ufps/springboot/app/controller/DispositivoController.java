package com.ufps.springboot.app.controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufps.springboot.app.models.entities.Conexion;
import com.ufps.springboot.app.models.entities.Dispositivo;
import com.ufps.springboot.app.models.entities.Historial;
import com.ufps.springboot.app.models.entities.TipoDispositivo;
import com.ufps.springboot.app.models.service.IConexionService;
import com.ufps.springboot.app.models.service.IDispositivoService;

@Controller
@RequestMapping
public class DispositivoController {
	
	@Autowired
	private IDispositivoService dispositivoServce;
	
	@Autowired
	private IConexionService ConexionService;
	
	
	
	@GetMapping({"/index","/"})
	public String index(Model model) {
		model.addAttribute("titulo", "Bienvenido a la Prueba Java Web");
		
		return "index";
	}
	
	@GetMapping(value = "dispo/listar")
	public String listar(Model model) {
		
		List<Dispositivo> dispositivos = dispositivoServce.findAll();
		
		model.addAttribute("titulo", "Listado de Dispositivos");
		model.addAttribute("dispositivos", dispositivos);
		
		return "dispositivo/listar";
}
	
	@GetMapping(value = "/dispo/form")
	public String crear(Map<String, Object> model) {
		List<TipoDispositivo> tipos = dispositivoServce.findAllDispositivos();
		
		Dispositivo dispo = new Dispositivo();
		model.put("dispositivo", dispo);
		model.put("tipos", tipos);
		model.put("titulo", "Formulario de Dispositivo");

		return "dispositivo/form";
	}
	
	@PostMapping("dispo/form")
	public String guardar(@Valid Dispositivo dispositivo, BindingResult result, @RequestParam String tipoD,  Model model, RedirectAttributes flash) {

		String mensaje = (dispositivo.getId() != null) ? "Dispositivo Editado con exito" : "Dispositivo Creado con exito";

		TipoDispositivo tipo = new TipoDispositivo();
		tipo.setId(Long.parseLong(tipoD));
		dispositivo.setTipoDispositivo(tipo);
		dispositivoServce.save(dispositivo);
		flash.addFlashAttribute("success", mensaje);
		return "redirect:listar";
	}
	
	@RequestMapping(value = "dispo/editar/{id}" , method = RequestMethod.GET)
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Dispositivo dispositivo = null;
		if (id > 0) {
			dispositivo = dispositivoServce.findOne(id);
			if (dispositivo == null) {
				flash.addFlashAttribute("error", "El Dispositivo no Existe en la Base de Datos");
				return "redirect:/listar";

			}

		} else {
			return "redirect:/listar";

		}
		
		List<TipoDispositivo> tipos = dispositivoServce.findAllDispositivos();
		
		
		model.put("dispositivo", dispositivo);
		model.put("titulo", "Editar Dispositivo");
		model.put("tipos", tipos);

		return "dispositivo/form";
	}
	
	@RequestMapping(value = "/dispo/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
				dispositivoServce.delete(id);
				flash.addFlashAttribute("success", "Se ha Eliminado con Exito");
			}
		
		return "redirect:/dispo/listar";
	}
	
	@GetMapping("dispo/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id,Model model, RedirectAttributes flash) {
		Dispositivo dispo = dispositivoServce.findOne(id);
		if (dispo==null) {
			flash.addFlashAttribute("error", "El Dispositivo no existe en la BD");
			return "redirect:../listar";
			
		}
		
		List<Historial> h = dispositivoServce.listas(id);
		
		model.addAttribute("historial", h);
		model.addAttribute("titulo", "Historial de Conexiones");
		model.addAttribute("dispositivo", dispo);
		
		return "dispositivo/ver";
		
	}
	
 /*@GetMapping("/prueba")
	public String prueba(@RequestParam(required = false) String id, Model model) {
		
		String url = "http://localhost:8082/api/rest";
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<JsonResultado[]> response =
	            restTemplate.getForEntity(url, JsonResultado[].class);

		return "";
	}*/
	
	
	@GetMapping("/dispo/asignar/{id}")
	public String asignar(@PathVariable(value = "id") Long id,Map<String, Object> model, RedirectAttributes flash) {
		
		Dispositivo dispositivo = null;
		if (id > 0) {
			dispositivo = dispositivoServce.findOne(id);
			if (dispositivo == null) {
				flash.addFlashAttribute("error", "El Dispositivo no Existe en la Base de Datos");
				return "redirect:/dispo/listar";
			}
		} else {
			return "redirect:/listar";
		}
		List<Conexion> con = ConexionService.findAll();
		
		
		model.put("conexiones", con);
		model.put("dispositivo", dispositivo);
		model.put("titulo", "Asignacion de Conexion");
		return "dispositivo/asignar"; 
	}
	
	@PostMapping("dispo/guardar")
	public String guardar(Dispositivo dispositivo, @RequestParam Long con,  Model model, RedirectAttributes flash) {

		int x = dispositivoServce.cantidad(con);		
		if (x<=2) {
			
			Conexion conexion = new Conexion();
			conexion.setId(con);
			dispositivo.setConexion(conexion);
			dispositivo.setConectado(1);
			Historial historial = new Historial();
			historial.setConexion(dispositivo.getConexion());
			historial.setDispositivo(dispositivo);
			
			dispositivoServce.save(dispositivo);
			dispositivoServce.saveH(historial);
			
			flash.addFlashAttribute("success", "Conexion asignada con exito");
			
			return "redirect:listar";
			
		}else {
			flash.addFlashAttribute("error", "Esta conexion ya tiene 3 dispositivos");
			
			
		}

		
		return "redirect:listar";
	}
}
