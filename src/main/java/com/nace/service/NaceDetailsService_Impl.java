package com.nace.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nace.common.msgs.BaseResponse;
import com.nace.common.msgs.CustomMessage;
import com.nace.common.utils.Topic;
import com.nace.dto.OrderDetailsDTO;
import com.nace.entity.OrderDetails;
import com.nace.exception.CustomDataIntegrityViolationException;
import com.nace.exception.RecordNotFoundException;
import com.nace.repo.OrderDAO;

@Service
@Transactional
public class NaceDetailsService_Impl {

	@Autowired
	private OrderDAO orderDAO;

	public Optional<OrderDetails>	findByOrderId(Long orderId) {		
			return orderDAO.findById(orderId);
	}

	public BaseResponse createOrUpdateOrder(OrderDetails orderdetails) {
		try {
			orderDAO.save(orderdetails);
		} catch (DataIntegrityViolationException ex) {
			throw new CustomDataIntegrityViolationException(ex.getCause().getCause().getMessage());
		}
		return new BaseResponse(Topic.Order.getName() + CustomMessage.SAVE_SUCCESS_MESSAGE);
	}
}
