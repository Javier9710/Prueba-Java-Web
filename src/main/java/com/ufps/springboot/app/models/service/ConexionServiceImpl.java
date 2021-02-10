package com.ufps.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.springboot.app.models.dao.IConexionDao;
import com.ufps.springboot.app.models.dao.IHistorialDao;
import com.ufps.springboot.app.models.dao.ITipoCifradoDao;
import com.ufps.springboot.app.models.entities.Conexion;
import com.ufps.springboot.app.models.entities.Historial;
import com.ufps.springboot.app.models.entities.TipoCifrado;

@Service
public class ConexionServiceImpl implements IConexionService {

	@Autowired
	private IConexionDao conexionDao;
	
	@Autowired
	private ITipoCifradoDao tipoDao;
	
	@Autowired
	private IHistorialDao historialDao;
	
	//--------------------------------------------------
	
	@Override
	public List<Conexion> findAll() {
		return (List<Conexion>) conexionDao.findAll() ;
	}

	@Override
	public void save(Conexion conexion) {
		conexionDao.save(conexion);
	}

	@Override
	public List<TipoCifrado> findAllTipos() {
		
		return (List<TipoCifrado>) tipoDao.findAll();
	}

	@Override
	public Conexion findOne(Long id) {
		return conexionDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		conexionDao.deleteById(id);
	}

	@Override
	public List<Historial> listasCon(Long id) {
		return (List<Historial>)historialDao.listasCon(id);
	}

}
