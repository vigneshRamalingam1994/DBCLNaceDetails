package com.nace.service;

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

	public OrderDetailsDTO findByOrderId(Long orderId) {
		if (orderDAO.existsById(orderId)) {
			OrderDetails orderentity = orderDAO.findByorderid(orderId);
			return copyOrderEntityToDto(orderentity);
		} else {
			throw new RecordNotFoundException(CustomMessage.DOESNOT_EXIT + orderId);
		}
	}

	public BaseResponse createOrUpdateOrder(OrderDetailsDTO orderdetailsdto) {
		try {
			OrderDetails orderentity = copyOrderDtoToEntity(orderdetailsdto);
			orderDAO.save(orderentity);
		} catch (DataIntegrityViolationException ex) {
			throw new CustomDataIntegrityViolationException(ex.getCause().getCause().getMessage());
		}
		return new BaseResponse(Topic.Order.getName() + CustomMessage.SAVE_SUCCESS_MESSAGE);
	}

	private OrderDetailsDTO copyOrderEntityToDto(OrderDetails orderEntity) {
		OrderDetailsDTO orderDTO = new OrderDetailsDTO();
		BeanUtils.copyProperties(orderEntity, orderDTO);
		return orderDTO;
	}

	private OrderDetails copyOrderDtoToEntity(OrderDetailsDTO orderdetailsdto) {
		OrderDetails Orderdetails = new OrderDetails();
		BeanUtils.copyProperties(orderdetailsdto, Orderdetails);
		return Orderdetails;
	}
}
