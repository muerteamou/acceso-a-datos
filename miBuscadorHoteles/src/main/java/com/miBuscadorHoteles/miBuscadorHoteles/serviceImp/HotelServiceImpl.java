package com.miBuscadorHoteles.miBuscadorHoteles.serviceImp;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miBuscadorHoteles.miBuscadorHoteles.domain.Hotel;
import com.miBuscadorHoteles.miBuscadorHoteles.exception.HotelNotFoundException;
import com.miBuscadorHoteles.miBuscadorHoteles.repository.HotelRepository;
import com.miBuscadorHoteles.miBuscadorHoteles.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Set<Hotel> findAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Set<Hotel> findByCategoria(String categoria) {
		return hotelRepository.findByCategoria(categoria);
	}

	@Override
	public Set<Hotel> findByLocalidad(String localidad) {
		return hotelRepository.findByLocalidad(localidad);
	}
	
	@Override
	public Optional<Hotel> findByID(long id ){
		return hotelRepository.findById(id);
	}
	
	@Override
	public Hotel addHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	@Override
	public Hotel modifyHotel(long id, Hotel newHotel) {
		Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException(id));
		newHotel.setId(hotel.getId());
		return hotelRepository.save(newHotel);
	}
	
	@Override
	public void deleteHotel(long id) {
		hotelRepository.findById(id).orElseThrow(()-> new HotelNotFoundException(id));
		hotelRepository.deleteById(id);
	}

}