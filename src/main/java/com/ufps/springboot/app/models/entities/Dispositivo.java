package com.ufps.springboot.app.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "dispositivos")
public class Dispositivo implements Serializable{

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String mac;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_dispositivo")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private TipoDispositivo tipoDispositivo;
	
	private int conectado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conexion")
	@JsonBackReference
	private Conexion conexion;
	
	private String ip;
	
	@OneToMany(mappedBy ="dispositivo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Historial> historial;
	
	//------------------------------------------------------------------------------------
	
	
	@PrePersist
	public void prePersist() {
		conectado = 0;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
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

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexionAct(Conexion conexion) {
		this.conexion = conexion;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
