package mx.com.cuamatziinc.reservasalas.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RequestSala implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nombre;
	@NotNull
	private Integer numeroPiso;
	@NotNull
	private Boolean proyector;
	@NotNull
	private Boolean pantalla;
	@NotNull
	private Boolean altavoces;
	@NotNull
	private Integer capacidad;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getNumeroPiso() {
		return numeroPiso;
	}
	public void setNumeroPiso(Integer numeroPiso) {
		this.numeroPiso = numeroPiso;
	}
	public Boolean getProyector() {
		return proyector;
	}
	public void setProyector(Boolean proyector) {
		this.proyector = proyector;
	}
	public Boolean getPantalla() {
		return pantalla;
	}
	public void setPantalla(Boolean pantalla) {
		this.pantalla = pantalla;
	}
	public Boolean getAltavoces() {
		return altavoces;
	}
	public void setAltavoces(Boolean altavoces) {
		this.altavoces = altavoces;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
	

}
