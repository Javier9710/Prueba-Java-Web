package com.ufps.springboot.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufps.springboot.app.models.entities.Dispositivo;
import com.ufps.springboot.app.models.service.IDispositivoService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/rest")
public class RestController {
	
	@Autowired
	private IDispositivoService dispositivoService;
	
	@GetMapping
	public List<Dispositivo> lista(){
		return dispositivoService.findAll();
	}

}
