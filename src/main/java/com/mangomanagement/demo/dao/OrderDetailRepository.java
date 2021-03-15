package com.mangomanagement.demo.dao;

import com.mangomanagement.demo.Entity.OrderDetail;
import com.mangomanagement.demo.Entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId>, JpaSpecificationExecutor<OrderDetail> {

}