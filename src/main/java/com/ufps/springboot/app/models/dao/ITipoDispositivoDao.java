package com.ufps.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.app.models.entities.TipoDispositivo;

public interface ITipoDispositivoDao extends CrudRepository<TipoDispositivo, Long> {

}
