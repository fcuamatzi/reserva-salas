package mx.com.cuamatziinc.reservasalas.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.validation.Valid;
import mx.com.cuamatziinc.reservasalas.dto.RequestPiso;
import mx.com.cuamatziinc.reservasalas.persistence.entity.Piso;

public interface IPisoService {

	Page<Piso> findAll(Pageable pageable);

	Optional<Piso> findPisoById(Long pisoId);

	Piso createPiso(@Valid RequestPiso requestPiso);

	Piso updatePiso(Long pisoId, @Valid RequestPiso requestPiso);

	Piso disablePiso(Long pisoId);

}
