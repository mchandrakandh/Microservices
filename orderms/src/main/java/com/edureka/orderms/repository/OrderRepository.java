package com.edureka.orderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edureka.orderms.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
