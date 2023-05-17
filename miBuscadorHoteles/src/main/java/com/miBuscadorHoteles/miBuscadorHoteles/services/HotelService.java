package com.miBuscadorHoteles.miBuscadorHoteles.services;

import java.util.Optional;
import java.util.Set;

import com.miBuscadorHoteles.miBuscadorHoteles.domain.Hotel;

public interface HotelService {

	Set<Hotel> findAll();

	Set<Hotel> findByCategoria(String categoria);
	
	Set<Hotel> findByLocalidad(String localidad);

	Optional<Hotel> findByID(long id);

	Hotel addHotel(Hotel hotel);

	Hotel modifyHotel(long id, Hotel newHotel);

	void deleteHotel(long id);

}
