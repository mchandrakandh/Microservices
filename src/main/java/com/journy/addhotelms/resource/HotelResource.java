package com.journy.addhotelms.resource;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestBody;


import com.journy.addhotelms.repository.HotelRepository;
import com.journy.addhotelms.model.Hotel;

@RestController


public class HotelResource {

	private final HotelRepository hotelRepository;
	public HotelResource(HotelRepository hotelRepository)
	{
		this.hotelRepository = hotelRepository;
	}
	
	@GetMapping("/hotels")
	public List<Hotel> getAllHotels()
	
	{
		//
		return hotelRepository.findAll();
	}

	// curl -d "name=abc&address=abcd" -X POST http://localhost:8192/new

	@PostMapping("/new")
	//public Hotel createHotel(@Valid @RequestBody Hotel hotel)
	public Hotel createHotel(@Valid Hotel hotel)
	{
		return hotelRepository.save(hotel);
	}
	
}

