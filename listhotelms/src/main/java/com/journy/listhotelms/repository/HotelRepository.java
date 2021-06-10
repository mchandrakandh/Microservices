package com.journy.listhotelms.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.journy.listhotelms.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

	@Query("select c from Hotel c")
	Page<Hotel> findAllPage(Pageable pageable);
}
