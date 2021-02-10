package com.ufps.springboot.app.models.service;

import java.util.List;


import com.ufps.springboot.app.models.entities.Conexion;
import com.ufps.springboot.app.models.entities.Historial;
import com.ufps.springboot.app.models.entities.TipoCifrado;

public interface IConexionService {
	
	
	public List<Conexion> findAll();

	public void save(Conexion conexion);
	
	public List<TipoCifrado> findAllTipos();

	public Conexion findOne(Long id);
	
	public void deleteById(Long id);

	public List<Historial> listasCon(Long id);
	

}
