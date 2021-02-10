package com.ufps.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.springboot.app.models.dao.IDispositivoDao;
import com.ufps.springboot.app.models.dao.IHistorialDao;
import com.ufps.springboot.app.models.dao.ITipoDispositivoDao;
import com.ufps.springboot.app.models.entities.Dispositivo;
import com.ufps.springboot.app.models.entities.Historial;
import com.ufps.springboot.app.models.entities.TipoDispositivo;

@Service
public class DispositivoServiceImpl implements IDispositivoService {

	@Autowired
	private IDispositivoDao dispositivoDao;
	
	@Autowired
	private ITipoDispositivoDao tipoDao;
	
	@Autowired
	private IHistorialDao historialDao;
	
	//-----------------------------------------------------------
	
	@Override
	public List<Dispositivo> findAll() {
		return (List<Dispositivo>) dispositivoDao.findAll();
	}

	@Override
	public void save(Dispositivo dispo) {
		dispositivoDao.save(dispo);
	}

	@Override
	public List<TipoDispositivo> findAllDispositivos() {
		return (List<TipoDispositivo>) tipoDao.findAll();
	}

	@Override
	public Dispositivo findOne(Long id) {
		return dispositivoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		dispositivoDao.deleteById(id);
	}

	@Override
	public List<Historial> listas(Long id) {
		
		return  (List<Historial>)historialDao.listas(id);
	}

	@Override
	public void saveH(Historial historial) {
		historialDao.save(historial);
		
	}

	@Override
	public int cantidad(Long id) {
		int can=0;
		can = dispositivoDao.cantidad(id);
		return can;
	}

}
