package com.ufps.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.app.models.entities.Conexion;

public interface IConexionDao extends CrudRepository<Conexion, Long> {

}
