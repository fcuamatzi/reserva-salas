package mx.com.cuamatziinc.reservasalas.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.validation.Valid;
import mx.com.cuamatziinc.reservasalas.dto.RequestSala;
import mx.com.cuamatziinc.reservasalas.persistence.entity.Sala;

public interface ISalaService {
	
	Page<Sala> findAll(Pageable pageable);
	
	Optional<Sala> findSalaById(Long salaId);
	
	Sala createSala(RequestSala requestSala);

	Sala updateSala(Long salaId, @Valid RequestSala requestSala);

	Sala disableSala(Long salaId);
	
}
