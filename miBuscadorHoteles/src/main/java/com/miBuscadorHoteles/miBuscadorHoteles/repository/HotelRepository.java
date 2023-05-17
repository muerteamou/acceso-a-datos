package com.miBuscadorHoteles.miBuscadorHoteles.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miBuscadorHoteles.miBuscadorHoteles.domain.Hotel;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {

	Set<Hotel> findAll();

	Set<Hotel> findByCategoria(String categoria);

	Set<Hotel> findByLocalidad(String localidad);
	
	Hotel findByNombre(String nombre);
}