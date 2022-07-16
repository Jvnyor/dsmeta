package com.Jvnyor.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Jvnyor.dsmeta.entities.Sale;
import com.Jvnyor.dsmeta.services.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {

	@Autowired
	private SaleService service;

	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "", required = false) String minDate, 
			@RequestParam(value = "maxDate", defaultValue = "", required = false) String maxDate, 
			Pageable pageable) {
		return service.findSales(minDate, maxDate, pageable);
	}
}
