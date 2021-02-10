package com.ufps.springboot.app.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "conexiones")
public class Conexion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(name = "tipo_con")
	private int tipoCon;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_cifrado")
	private TipoCifrado tipoCifrado;
	
	@OneToMany(mappedBy ="conexion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Dispositivo> dispositivos;
	
	private String nombre;
	
	private String usuario;
	
	private String contraseña;
	
	
	@OneToMany(mappedBy ="conexion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Historial> historial;
	
	
	//----------------------------------------------------------------------------------
	
	
	public int getTipoCon() {
		return tipoCon;
	}

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public void setTipoCon(int tipoCon) {
		this.tipoCon = tipoCon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoCifrado getTipoCifrado() {
		return tipoCifrado;
	}

	public void setTipoCifrado(TipoCifrado tipoCifrado) {
		this.tipoCifrado = tipoCifrado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	

}
