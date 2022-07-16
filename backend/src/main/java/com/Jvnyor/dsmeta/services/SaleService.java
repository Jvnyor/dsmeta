package com.Jvnyor.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Jvnyor.dsmeta.entities.Sale;
import com.Jvnyor.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {

		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

		LocalDate min = !minDate.isBlank() ? LocalDate.parse(minDate) : today.minusDays(365);
		LocalDate max = !maxDate.isBlank() ? LocalDate.parse(maxDate) : today;

		return repository.findSales(min, max, pageable);
	}
}
