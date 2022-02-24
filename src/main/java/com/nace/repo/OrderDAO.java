package com.nace.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nace.entity.OrderDetails;

@Repository
public interface OrderDAO   extends JpaRepository<OrderDetails, Long>
{ 
}
