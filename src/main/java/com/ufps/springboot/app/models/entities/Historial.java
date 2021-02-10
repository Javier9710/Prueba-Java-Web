package com.ufps.springboot.app.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;


@Entity
@Table(name = "historial")
public class Historial implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dispositivo_id")
	private Dispositivo dispositivo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conexion_id")
	private Conexion conexion; 
	
	
	@Column(name = "fecha")
	private Date fecha;
	
	//----------------------------------------------
	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@PrePersist
	public void prePersist() {
		fecha = new Date();
	}
	
	public Conexion getConexion() {
		return conexion;
	}


	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}


	public Dispositivo getDispositivo() {
		return dispositivo;
	}


	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	
}


 