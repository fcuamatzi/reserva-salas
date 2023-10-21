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
import mx.com.cuamatziinc.reservasalas.dto.RequestSala;
import mx.com.cuamatziinc.reservasalas.persistence.entity.Sala;
import mx.com.cuamatziinc.reservasalas.service.ISalaService;

@RestController
@RequestMapping("/salas")
public class SalasController {
	
	@Autowired
	private ISalaService salaService;
	
	@GetMapping
	public ResponseEntity<Page<?>> findSalas(Pageable pageable){
		
		Page<Sala> salasPage =salaService.findAll(pageable);
		
		return ResponseEntity.ok(salasPage);
		
	}
	
	@GetMapping("/{salaId}")
	public ResponseEntity<?> findSalaById(@PathVariable Long salaId){
		
		Optional<Sala> salaOp = salaService.findSalaById(salaId);
		
		if (salaOp.isEmpty()) {
			
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(salaOp.get());
		
	}
	
	@PostMapping
	public ResponseEntity<?> createSala(@RequestBody @Valid RequestSala requestSala){
		
		Sala sala = salaService.createSala(requestSala);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(sala);
		
	}
	
	@PutMapping("/{salaId}")
	public ResponseEntity<?> updateSalaById(@PathVariable Long salaId, @RequestBody @Valid RequestSala requestSala){
		
		Sala sala = salaService.updateSala(salaId, requestSala);
		
		return ResponseEntity.status(HttpStatus.OK).body(sala);
		
	}
	
	
	@DeleteMapping("/{salaId}")
	public ResponseEntity<?> disableSalaById(@PathVariable Long salaId){
		
		Sala sala = salaService.disableSala(salaId);
		
		return ResponseEntity.status(HttpStatus.OK).body(sala);
		
	}
	
}
