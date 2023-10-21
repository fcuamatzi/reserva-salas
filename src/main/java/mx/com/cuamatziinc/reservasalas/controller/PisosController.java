package mx.com.cuamatziinc.reservasalas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import mx.com.cuamatziinc.reservasalas.dto.RequestPiso;
import mx.com.cuamatziinc.reservasalas.persistence.entity.Piso;
import mx.com.cuamatziinc.reservasalas.service.IPisoService;

@RestController
@RequestMapping("/pisos")
public class PisosController {
	
	@Autowired
	private IPisoService pisoService;
	
	@GetMapping
	public ResponseEntity<Page<?>> findPisos(Pageable pageable){
		
		Page<Piso> pisosPage =pisoService.findAll(pageable);
		
		return ResponseEntity.ok(pisosPage);
		
	}
	
	@GetMapping("/{pisoId}")
	public ResponseEntity<?> findPisoById(@PathVariable Long pisoId){
		
		Optional<Piso> pisoOp = pisoService.findPisoById(pisoId);
		
		if (pisoOp.isEmpty()) {
			
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pisoOp.get());
		
	}
	
	@PostMapping
	public ResponseEntity<?> createPiso(@RequestBody @Valid RequestPiso requestPiso){
		
		Piso piso = pisoService.createPiso(requestPiso);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(piso);
		
	}
	
	@PutMapping("/{pisoId}")
	public ResponseEntity<?> updatePisoById(@PathVariable Long pisoId, @RequestBody @Valid RequestPiso requestPiso){
		
		Piso piso = pisoService.updatePiso(pisoId, requestPiso);
		
		return ResponseEntity.status(HttpStatus.OK).body(piso);
		
	}
	
	
	@DeleteMapping("/{pisoId}")
	public ResponseEntity<?> disablePisoById(@PathVariable Long pisoId){
		
		Piso piso = pisoService.disablePiso(pisoId);
		
		return ResponseEntity.status(HttpStatus.OK).body(piso);
		
	}
	
}
