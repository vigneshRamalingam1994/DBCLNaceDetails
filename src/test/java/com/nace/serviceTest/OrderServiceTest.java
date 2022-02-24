package com.nace.serviceTest;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nace.common.msgs.BaseResponse;
import com.nace.entity.OrderDetails;
import com.nace.repo.OrderDAO;
import com.nace.service.NaceDetailsService_Impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTest {
	
    @Mock
    private OrderDAO orderepo;

    @InjectMocks
    private NaceDetailsService_Impl service;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetOrderById() {
    	long x=1; 
    	OrderDetails orderdetails = new OrderDetails(1, 0, "TEST", "TEST", "TEST", "TEST", "TEST", "TEST", "TEST", "TEST");
        when(orderepo.findById(1L)).thenReturn(Optional.of(orderdetails));
        Optional<OrderDetails> resultOpt = service.findByOrderId(x);
        OrderDetails result = resultOpt.get();
        assertEquals(1, result.getOrderid());
        assertEquals("TEST", result.getCode());
        assertEquals("TEST", result.getAddons());
    }
    
    @Test
    public void saveOrder() {
    	OrderDetails orderdetails = new OrderDetails(2, 2, "TEST2", "TEST2", "TEST2", "TEST2", "TEST2", "TEST2", "TEST", "TEST2");
        when(orderepo.save(orderdetails)).thenReturn(orderdetails);
        BaseResponse result = service.createOrUpdateOrder(orderdetails);
        assertEquals("ORDER has been saved successfully!", result.getMessage());
    }

}
