package mx.com.cuamatziinc.reservasalas.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.cuamatziinc.reservasalas.persistence.entity.Sala;

public interface ISalaRepository extends JpaRepository<Sala, Long> {

}
