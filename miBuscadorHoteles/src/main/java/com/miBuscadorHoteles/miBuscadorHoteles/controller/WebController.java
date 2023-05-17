package com.miBuscadorHoteles.miBuscadorHoteles.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miBuscadorHoteles.miBuscadorHoteles.domain.Hotel;
import com.miBuscadorHoteles.miBuscadorHoteles.services.HotelService;

@Controller
public class WebController {
	@Autowired
	private HotelService hotelService;

	@RequestMapping(value = "/")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value = "/catalog")
	public String catalog(Model model) {
		Set<Hotel> hoteles = hotelService.findAll();
		model.addAttribute("hoteles", hoteles);
		return "catalog";

	}
}