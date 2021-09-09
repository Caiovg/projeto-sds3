package com.devsuperior.dsvendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.service.SellerService;
import com.devsuperior.dsvendas.dtos.SellerDTO;
import com.devsuperior.dsvendas.model.Seller;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {
	
	@Autowired
	private SellerService services;
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll(){
		List<SellerDTO> list = services.findAll();
		return ResponseEntity.ok(list);
	}

	@PostMapping
	public ResponseEntity<Seller> postCategoria(@RequestBody Seller se){
		ResponseEntity<Seller> obj = services.postCategory(se);
		return obj;
	}
}
