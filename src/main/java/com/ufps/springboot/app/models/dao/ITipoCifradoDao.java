package com.ufps.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.app.models.entities.TipoCifrado;

public interface ITipoCifradoDao extends CrudRepository<TipoCifrado, Long> {

}
