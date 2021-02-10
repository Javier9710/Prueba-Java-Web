package com.ufps.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.app.models.entities.Historial;

public interface IHistorialDao extends CrudRepository<Historial, Long> {
	
	@Query("select h from Historial h where h.dispositivo.id=?1")
	public List<Historial> listas(Long id);
	
	@Query("select h from Historial h where h.conexion.id=?1")
	public List<Historial> listasCon(Long id);

}
