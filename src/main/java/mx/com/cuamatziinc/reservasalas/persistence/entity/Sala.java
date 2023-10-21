package mx.com.cuamatziinc.reservasalas.persistence.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salas")
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sala_id")
	private Integer salaId;
	private String nombre;
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;
	private Boolean proyector;
	private Boolean pantalla;
	private Boolean altavoces;
	private Integer capacidad;
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "piso_id")
	private Piso piso;
	
	public Sala() {
		
	}
	
	
	public Integer getSalaId() {
		return salaId;
	}
	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
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


	public Piso getPiso() {
		return piso;
	}


	public void setPiso(Piso piso) {
		this.piso = piso;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
