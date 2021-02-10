package com.ufps.springboot.app.models.service;

import java.util.List;

import com.ufps.springboot.app.models.entities.Dispositivo;
import com.ufps.springboot.app.models.entities.Historial;
import com.ufps.springboot.app.models.entities.TipoDispositivo;

public interface IDispositivoService {
	
	
	public List<Dispositivo> findAll();
	
	public void save(Dispositivo dispo);

	public List<TipoDispositivo> findAllDispositivos();

	public Dispositivo findOne(Long id);
	
	public void delete(Long id);
	
	public int cantidad(Long id);
	
	public List<Historial> listas(Long id);
	
	public void saveH(Historial historial);
	

	

}
