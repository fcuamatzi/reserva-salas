package mx.com.cuamatziinc.reservasalas.service.imp;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.com.cuamatziinc.reservasalas.dto.RequestPiso;
import mx.com.cuamatziinc.reservasalas.exception.ObjectNotFoundException;
import mx.com.cuamatziinc.reservasalas.persistence.entity.Piso;
import mx.com.cuamatziinc.reservasalas.persistence.repository.IPisoRepository;
import mx.com.cuamatziinc.reservasalas.service.IPisoService;

@Service
public class PisoService implements IPisoService {
	
	@Autowired
	private IPisoRepository pisoRepository;
	
	@Override
	public Page<Piso> findAll(Pageable	 pageable) {
		
		return pisoRepository.findAll(pageable);
	}

	@Override
	public Optional<Piso> findPisoById(Long pisoId) {
		// TODO Auto-generated method stub
		return pisoRepository.findById(pisoId);
	}

	@Override
	public Piso createPiso(RequestPiso requestPiso) {
		
		Piso piso = new Piso();
		
		piso.setFechaAlta(new Date());
		piso.setStatus(true);
		
		piso.setNombre(requestPiso.getNombre());
		
		return pisoRepository.save(piso);
	}

	@Override
	public Piso updatePiso(Long pisoId, RequestPiso requestPiso) {
		
		Piso pisoFromBd = pisoRepository.findById(pisoId)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto no encontrado con id " + pisoId));
		
		pisoFromBd.setFechaActualizacion(new Date());
		
		pisoFromBd.setNombre(requestPiso.getNombre());
		
		return pisoRepository.save(pisoFromBd);
		
	}

	@Override
	public Piso disablePiso(Long pisoId) {
		
		Piso pisoFromBd = pisoRepository.findById(pisoId)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto no encontrado con id " + pisoId));
		
		pisoFromBd.setFechaActualizacion(new Date());
		pisoFromBd.setStatus(false);
		
		return pisoRepository.save(pisoFromBd);
	}

}
