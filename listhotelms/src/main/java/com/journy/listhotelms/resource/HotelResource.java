package com.journy.listhotelms.resource;
import java.util.List;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.journy.listhotelms.repository.HotelRepository;
import com.journy.listhotelms.model.Hotel;

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


	@GetMapping(path = "/hotels/page")
	Page<Hotel> loadHotelPage(@PageableDefault(page = 0, size = 10) Pageable pageable)
	{
		return hotelRepository.findAll(pageable);
		//return hotelRepository.findAllPage(pageable);
		
	}
	
}

