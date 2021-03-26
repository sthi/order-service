package com.javathi.order.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javathi.order.dao.OderDao;
import com.javathi.order.entity.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private OderDao orderDao;
	
	@GetMapping
	public List<Order> getOrder(){
		return orderDao.getOrders()
				.stream().sorted(Comparator.comparing(Order::getPrice))
				.collect(Collectors.toList());
	}
	
	  

}
