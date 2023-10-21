package mx.com.cuamatziinc.reservasalas.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

public class RequestPiso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
