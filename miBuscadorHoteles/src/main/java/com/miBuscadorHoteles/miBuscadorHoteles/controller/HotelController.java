package com.miBuscadorHoteles.miBuscadorHoteles.controller;

import static com.miBuscadorHoteles.miBuscadorHoteles.controller.Response.NOT_FOUND;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.miBuscadorHoteles.miBuscadorHoteles.domain.Hotel;
import com.miBuscadorHoteles.miBuscadorHoteles.exception.HotelNotFoundException;
import com.miBuscadorHoteles.miBuscadorHoteles.services.HotelService;

@RestController
public class HotelController {

	private final Logger logger = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	private HotelService hotelService;

	@GetMapping("/hoteles/categoria/")
	public ResponseEntity<Set<Hotel>> getHotelesByCategory(@RequestParam(value = "categoria", defaultValue = "") String categoria) {
		logger.info("inicio getHoteles");

		Set<Hotel> hoteles = null;
		if (categoria.equals(""))
			hoteles = hotelService.findAll();
		else
			hoteles = hotelService.findByCategoria(categoria);
		logger.info("fin getHoteles");
		return new ResponseEntity<>(hoteles, HttpStatus.OK);
	}
	
	@GetMapping("/hoteles/localidad/")
	public ResponseEntity<Set<Hotel>> getHotelesByCity(@RequestParam(value = "localidad", defaultValue = "") String localidad) {
		logger.info("inicio getHoteles");

		Set<Hotel> hoteles = null;
		if (localidad.equals(""))
			hoteles = hotelService.findAll();
		else
			hoteles = hotelService.findByLocalidad(localidad);
		logger.info("fin getHoteles");
		return new ResponseEntity<>(hoteles, HttpStatus.OK);
	}

	@GetMapping("/hoteles/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable long id) {
		Hotel hotel = hotelService.findByID(id).orElseThrow(() -> new HotelNotFoundException(id));
		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}

	@PostMapping("/hoteles")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
		Hotel addedHotel = hotelService.addHotel(hotel);
		return new ResponseEntity<>(addedHotel, HttpStatus.OK);
	}

	@PutMapping("/hoteles/{id}")
	public ResponseEntity<Hotel> modifyHotel(@PathVariable long id, @RequestBody Hotel newHotel) {
		Hotel habitacion = hotelService.modifyHotel(id, newHotel);
		return new ResponseEntity<>(habitacion, HttpStatus.OK);
	}

	@DeleteMapping("/hoteles/{id}")
	public ResponseEntity<Response> deleteHotel(@PathVariable long id) {
		hotelService.deleteHotel(id);
		return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
	}

	@ExceptionHandler(HotelNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(HotelNotFoundException pnfe) {
		Response response = Response.errorResponse(NOT_FOUND, pnfe.getMessage());
		logger.error(pnfe.getMessage(), pnfe);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
