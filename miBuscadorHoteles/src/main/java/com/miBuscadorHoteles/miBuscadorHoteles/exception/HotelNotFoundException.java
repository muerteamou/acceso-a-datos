package com.miBuscadorHoteles.miBuscadorHoteles.exception;

public class HotelNotFoundException extends RuntimeException {
	
	public HotelNotFoundException() {
		super();
	}
	
	public HotelNotFoundException(String message) {
		super(message);
	}

	public HotelNotFoundException(long id) {
		super("Hotel not found: " + id);
	}
}
