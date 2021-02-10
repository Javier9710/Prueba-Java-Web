package com.ufps.springboot.app.utils;

import com.ufps.springboot.app.models.entities.TipoDispositivo;

public class JsonResultado {

	private Boolean error;
	
	private Long id;
	
	private String mac;
	
	private TipoDispositivo tipoDispositivo;
	
	private int conectado;
	
	private String ip;
	
	//--------------------------------------------

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public TipoDispositivo getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public int getConectado() {
		return conectado;
	}

	public void setConectado(int conectado) {
		this.conectado = conectado;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		
		return super.toString();
	}


	
	
}