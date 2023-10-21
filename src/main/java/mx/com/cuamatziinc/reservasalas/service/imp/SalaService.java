package mx.com.cuamatziinc.reservasalas.service.imp;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import mx.com.cuamatziinc.reservasalas.dto.RequestSala;
import mx.com.cuamatziinc.reservasalas.exception.ObjectNotFoundException;
import mx.com.cuamatziinc.reservasalas.persistence.entity.Piso;
import mx.com.cuamatziinc.reservasalas.persistence.entity.Sala;
import mx.com.cuamatziinc.reservasalas.persistence.repository.ISalaRepository;
import mx.com.cuamatziinc.reservasalas.service.ISalaService;

@Service
public class SalaService implements ISalaService {
	
	@Autowired
	private ISalaRepository salaRepository;

	@Override
	public Page<Sala> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return salaRepository.findAll(pageable);
	}

	@Override
	public Optional<Sala> findSalaById(Long salaId) {
		// TODO Auto-generated method stub
		return salaRepository.findById(salaId);
	}

	@Override
	public Sala createSala(RequestSala requestSala) {
		
		Sala sala = new Sala();
		
		sala.setFechaAlta(new Date());
		sala.setStatus(true);
		
		sala.setAltavoces(requestSala.getAltavoces());
		sala.setCapacidad(requestSala.getCapacidad());
		sala.setNombre(requestSala.getNombre());
		sala.setPantalla(requestSala.getPantalla());
		
		Piso piso = new Piso();
		piso.setPisoId(requestSala.getNumeroPiso());
		
		sala.setPiso(piso);
		sala.setProyector(requestSala.getProyector());
		
		return salaRepository.save(sala);
	}

	@Override
	public Sala updateSala(Long salaId, RequestSala requestSala) {
		
		Sala salaFromDb = salaRepository.findById(salaId)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto no encontrado"));
		
		salaFromDb.setFechaActualizacion(new Date());
		
		salaFromDb.setAltavoces(requestSala.getAltavoces());
		salaFromDb.setCapacidad(requestSala.getCapacidad());
		salaFromDb.setNombre(requestSala.getNombre());
		salaFromDb.setPantalla(requestSala.getPantalla());
		
		Piso piso = new Piso();
		piso.setPisoId(requestSala.getNumeroPiso());
		
		salaFromDb.setPiso(piso);
		salaFromDb.setProyector(requestSala.getProyector());
		
		return salaRepository.save(salaFromDb);
		
	}

	@Override
	public Sala disableSala(Long salaId) {
		
		Sala salaFromDb = salaRepository.findById(salaId)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto no encontrado sala con id " + salaId));
		
		
		salaFromDb.setStatus(false);
		salaFromDb.setFechaActualizacion(new Date());
		
		return salaRepository.save(salaFromDb);
	}

}
