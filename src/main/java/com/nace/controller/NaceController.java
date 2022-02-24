package com.nace.controller;

import java.util.Optional;

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
import com.nace.entity.OrderDetails;
import com.nace.exception.RecordNotFoundException;
import com.nace.service.NaceDetailsService_Impl;

@RestController
@RequestMapping("/dbclm")
public class NaceController {

	@Autowired
	private NaceDetailsService_Impl naceDetailsService;


	@GetMapping("/nace/getDetails/byid")
	public ResponseEntity<OrderDetails> getBook(@NotNull(message = "Id can't be null") @RequestParam Long id) {
		Optional<OrderDetails> order = naceDetailsService.findByOrderId(id);
		OrderDetails OrderDetails=order.get();
        if (!order.isPresent()) {
            throw new RecordNotFoundException("Order doesn exist");
        }
		return new ResponseEntity<OrderDetails>(OrderDetails, HttpStatus.OK);
	}

	@PostMapping("/nace/addDetails")
	public ResponseEntity<BaseResponse> createBook(@RequestBody OrderDetails orderDetails) {
		BaseResponse order = naceDetailsService.createOrUpdateOrder(orderDetails);
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
}
