package com.nace.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nace.common.msgs.BaseResponse;
import com.nace.dto.OrderDetailsDTO;
import com.nace.service.NaceDetailsService_Impl;

@RestController
@RequestMapping("/dbclm")
public class NaceController {

	@Autowired
	private NaceDetailsService_Impl naceDetailsService;

	@GetMapping("/nace/getDetails/byid")
	public ResponseEntity<OrderDetailsDTO> getBook(@NotNull(message = "Id can't be null") @RequestParam Long id) {
		OrderDetailsDTO order = naceDetailsService.findByOrderId(id);
		return new ResponseEntity<OrderDetailsDTO>(order, HttpStatus.OK);
	}

	@PostMapping("/nace/addDetails")
	public ResponseEntity<BaseResponse> createBook(@RequestBody OrderDetailsDTO orderDetails) {
		BaseResponse order = naceDetailsService.createOrUpdateOrder(orderDetails);
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
}
