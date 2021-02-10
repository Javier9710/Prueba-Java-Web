package com.ufps.springboot.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.app.models.entities.Dispositivo;

public interface IDispositivoDao extends CrudRepository<Dispositivo, Long> {
	
	@Query("select count(d.id) from Dispositivo d where d.conexion.id=?1")
	public int cantidad(Long id);

}
