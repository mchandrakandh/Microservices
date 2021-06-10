package com.journy.addhotelms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.journy.addhotelms.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

	}
